const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();
const PORT = process.env.PORT || 3000;
const MONGO_URI = process.env.MONGO_URI || 'mongodb+srv://Cluster46831:d3lbcltXfUF8@cluster46831.jf4jkge.mongodb.net/inventory_db';

// Middleware
app.use(bodyParser.json());
app.use(cors());

// Connect to MongoDB
mongoose.connect(MONGO_URI, {
  useNewUrlParser: true,
  useUnifiedTopology: true,
}).then(() => {
  console.log('Connected to MongoDB');
}).catch(err => {
  console.error('Failed to connect to MongoDB', err);
});

// Item Schema and Model
const itemSchema = new mongoose.Schema({
  name: String,
  quantity: Number,
  price: Number,
  description: String,
  updated_at: { type: Date, default: Date.now }
});

const Item = mongoose.model('Item', itemSchema);

// User Schema and Model
const userSchema = new mongoose.Schema({
  username: String,
  email: String,
  password: String 
});

const User = mongoose.model('User', userSchema);

// Middleware to get item by ID
async function getItem(req, res, next) {
  let item;
  try {
    item = await Item.findById(req.params.id);
    if (item == null) {
      return res.status(404).json({ message: 'Cannot find item' });
    }
  } catch (err) {
    return res.status(500).json({ message: err.message });
  }
  res.item = item;
  next();
}


// Get all items
app.get('/api/items', async (req, res) => {
  try {
    const items = await Item.find();
    res.json(items);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

// Get a single item by name (case-insensitive)
app.get('/api/items/name/:name', async (req, res) => {
    try {
      
      const regex = new RegExp(`^${req.params.name}$`, 'i');
      const item = await Item.findOne({ name: regex });
      if (!item) {
        return res.status(404).json({ message: 'Item not found' });
      }
      res.json(item);
    } catch (err) {
      res.status(500).json({ message: err.message });
    }
  });
  

// Create a new item
app.post('/api/items', async (req, res) => {
  const item = new Item({
    name: req.body.name,
    quantity: req.body.quantity,
    price: req.body.price,
    description: req.body.description
  });
  try {
    const newItem = await item.save();
    res.status(201).json(newItem);
  } catch (err) {
    res.status(400).json({ message: err.message });
  }
});

// Update an item
app.patch('/api/items/:id', getItem, async (req, res) => {
  if (req.body.name != null) {
    res.item.name = req.body.name;
  }
  if (req.body.quantity != null) {
    res.item.quantity = req.body.quantity;
  }
  if (req.body.price != null) {
    res.item.price = req.body.price;
  }
  if (req.body.description != null) {
    res.item.description = req.body.description;
  }
  res.item.updated_at = Date.now();
  try {
    const updatedItem = await res.item.save();
    res.json(updatedItem);
  } catch (err) {
    res.status(400).json({ message: err.message });
  }
});

// Delete an item
app.delete('/api/items/:id', getItem, async (req, res) => {
    try {
      const result = await Item.deleteOne({ _id: res.item._id });
  
      if (result.deletedCount === 0) {
        return res.status(404).json({ message: 'Item not found' });
      }
  
      res.status(200).json({ message: 'Item deleted successfully' });
    } catch (err) {
      res.status(500).json({ message: 'Server error', error: err.message });
    }
  });
  

// User Routes

// Register a new user
app.post('/api/users/register', async (req, res) => {
  const user = new User({
    username: req.body.username,
    email: req.body.email,
    password: req.body.password 
  });
  try {
    const newUser = await user.save();
    res.status(201).json(newUser);
  } catch (err) {
    res.status(400).json({ message: err.message });
  }
});

// User login
app.post('/api/users/login', async (req, res) => {
  try {
    const user = await User.findOne({ email: req.body.email });
    if (user && user.password === req.body.password) { 
      res.json({ message: 'Login successful', user });
    } else {
      res.status(400).json({ message: 'Invalid credentials' });
    }
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
