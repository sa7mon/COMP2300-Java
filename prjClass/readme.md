#Project: Class

##Description
This project will demonstrate the following:
+ I can draw a UML diagram showing the variables and methods in a class.
+ I know how to designate data type as well as scope using UML syntax.
+ I can write my own custom classes.
+ I can utilize public, protected, and private variables appropriately.
+ I know how to access a public and/or protected variable directly.
+ I know how to protect information and validate incoming parameters before allowing them to be accepted by my custom classes.
+ I know how static variables work.

##Code requirements

###Standalone Class
+ 2 private variables as properties of your object. 
+ 1 protected variable as a property of your object.
+ 1 static variable
+ 3 overloaded constructors methods.
+ A get method for each variable
+ A set method for each variable. 
+ 3 other methods (not including set, get, or constructor methods)
+ At least one of the set methods must validate incoming data before the value of the property/variable is changed. If the incoming property value is not in range or appropriate then a default value should be used to set the variable.

###Main calling class
+ Create at least three different objects from the stand-alone class utilizing a different constructor method for creating each new object. (You do not have to use all of the objects you just created.)
+ Use methods from the stand-alone class to change one of the object's attributes/properties/variables.
+ Use methods from the stand-alone class to output or display the current attributes/properties/variables for at least one of the objects.
+ Try to change the value of property/variable using inappropriate data. (Make sure you use the set method that checks for bad data so you can show how it protects the objects from being hacked with data that is out of range or just plain wrong.) 
+ Use the appropriate get( ) method to display the before and after results of the property/variable.
+ Demonstrate accessing the protected property/variable in one of the objects by changing that property/variable directly without using a set( ) method. 
+ Use the appropriate get( ) method to display the before and after results of the property/variable.
+ Demonstrate how the static variable is shared between multiple instances of the class (An object made from a class is an instance of that class).