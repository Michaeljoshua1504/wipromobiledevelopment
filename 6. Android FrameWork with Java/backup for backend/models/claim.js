const mongoose = require('mongoose');

const claimSchema = new mongoose.Schema({
  userId: { type: mongoose.Schema.Types.ObjectId, ref: 'User', required: true },
  claimDate: { type: Date, default: Date.now },
  description: { type: String, required: true },
  photos: [{ type: String }], // Array of photo URLs or paths
  status: { type: String, default: 'Pending' }, // Possible statuses: Pending, Approved, Rejected, etc.
  agentCommunication: [
    {
      agentId: mongoose.Schema.Types.ObjectId,
      message: String,
      timestamp: { type: Date, default: Date.now },
    },
  ],
});

const Claim = mongoose.model('Claim', claimSchema);

module.exports = Claim;
