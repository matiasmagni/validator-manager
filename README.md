# validator-manager
GlobalLogic's Java career plan: excercise number 1. 

Validador

El cliente “X” necesita implementar un validador que sea cross para sus proyectos.

El validador debería poder ser reutilizable e incluso de ser necesario poder exportarlo a un JAR para reutilizarlo en otros proyectos.


Features:

El validador debe ser lo suficientemente versátil como para poder adaptarse a cualquier caso.

El validador debe poder recibir y almacenar reglas de validación para un clase de objetos en particular.

    Ejemplo:
    
ValidatorManager vm = new ValidatorManager();
vm.addRuleFor(MyObject.class, myRule);
vm.addRuleFor(MyObject.class, myRule2);
...


El validador debe poder verificar si un objeto es válido o no. 
El método deberá retornar la lista de reglas que NO validan o una lista vacía en caso que todas las reglas pasen ok.
También un metodo que diga si un objeto es valido o no.

Ejemplo:
    
ValidatorManager vm = new ValidatorManager();
...
List failRules = vm.validate(myobject);
...
boolean is valid = vm.isValid(myobject);
...



El validador debe poder retornar un “subvalidador” para un tipo de clase en particular que contenga todas las reglas necesarias para el tipo de objetos a validar.

Ejemplo:
    
ValidatorManager vm = new ValidatorManager();
...
Validator<T> validator = vm.buildValidatorFor(MyObject.class);
...
validator.addRule(myRule);
validator.addRule(myRule2);
...
List failRules = validator.validate(myobject);
boolean is valid = validator.isValid(myobject);


