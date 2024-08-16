import java.util.Scanner

data class Employee(
    val id: Int,
    val name: String,
    val age: Int,
    val department: String
)

fun main() {
    val employees = mutableListOf<Employee>()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\nEmployee Management System")
        println("1. Add Employee")
        println("2. View All Employees")
        println("3. Update Employee")
        println("4. Delete Employee")
        println("5. Exit")
        print("Enter your choice: ")

        when (scanner.nextLine().trim().toIntOrNull()) {
            1 -> addEmployee(employees, scanner)
            2 -> viewEmployees(employees)
            3 -> updateEmployee(employees, scanner)
            4 -> deleteEmployee(employees, scanner)
            5 -> {
                println("Exiting the system.")
                break
            }
            else -> println("Invalid choice. Please try again.")
        }
    }
}

fun addEmployee(employees: MutableList<Employee>, scanner: Scanner) {
    println("\nEnter Employee Details:")

    print("ID: ")
    val id = scanner.nextLine().trim().toIntOrNull()
    if (id == null) {
        println("Invalid ID. Please enter a valid number.")
        return
    }

    print("Name: ")
    val name = scanner.nextLine().trim()

    print("Age: ")
    val age = scanner.nextLine().trim().toIntOrNull()
    if (age == null) {
        println("Invalid age. Please enter a valid number.")
        return
    }

    print("Department: ")
    val department = scanner.nextLine().trim()

    employees.add(Employee(id, name, age, department))
    println("Employee added successfully.")
}

fun viewEmployees(employees: List<Employee>) {
    println("\nList of Employees:")
    for (employee in employees) {
        println(employee)
    }
}

fun updateEmployee(employees: MutableList<Employee>, scanner: Scanner) {
    print("\nEnter Employee ID to update: ")
    val id = scanner.nextLine().trim().toIntOrNull()
    if (id == null) {
        println("Invalid ID. Please enter a valid number.")
        return
    }

    val employee = employees.find { it.id == id }
    if (employee != null) {
        println("Current Details: $employee")

        print("Enter new Name: ")
        val name = scanner.nextLine().trim()

        print("Enter new Age: ")
        val age = scanner.nextLine().trim().toIntOrNull()
        if (age == null) {
            println("Invalid age. Please enter a valid number.")
            return
        }

        print("Enter new Department: ")
        val department = scanner.nextLine().trim()

        employees[employees.indexOf(employee)] = Employee(id, name, age, department)
        println("Employee updated successfully.")
    } else {
        println("Employee not found.")
    }
}

fun deleteEmployee(employees: MutableList<Employee>, scanner: Scanner) {
    print("\nEnter Employee ID to delete: ")
    val id = scanner.nextLine().trim().toIntOrNull()
    if (id == null) {
        println("Invalid ID. Please enter a valid number.")
        return
    }

    val employee = employees.find { it.id == id }
    if (employee != null) {
        employees.remove(employee)
        println("Employee deleted successfully.")
    } else {
        println("Employee not found.")
    }
}
