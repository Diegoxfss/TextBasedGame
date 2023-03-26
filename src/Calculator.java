class Calculator {
public int calculate(String operation, int num1, int num2) {
switch (operation) {
case "add":
return num1 + num2;
case "subtract":
return num1 - num2;
case "multiply":
return num1 * num2;
case "divide":
return num1 / num2;
default:
throw new IllegalArgumentException("Invalid operation: " + operation);
}
}
}