
package lox;

import java.util.List;
import java.util.Map;

class LoxClass implements LoxCallable {

  final String name;
  final Map<String, LoxFunction> methods;

  LoxClass(String name, Map<String, LoxFunction> methods) {
    this.name = name;
	  this.methods = methods;
  }

  @Override
  public String toString() {
    return this.name;
  }
  
  @Override
  public Object call(Interpreter interpreter, List<Object> arguments) {
    LoxInstance instance = new LoxInstance(this);
    return instance;
  }
  
  @Override
  public int arity() {
    return 0;
  }

  public LoxFunction findMethod(String lexeme) {
	  if (methods.containsKey(lexeme)) {
	    return methods.get(lexeme);
	  }

	  return null;
	}
}
