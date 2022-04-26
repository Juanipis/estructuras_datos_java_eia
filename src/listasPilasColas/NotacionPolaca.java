package listasPilasColas;

import java.util.Stack;

public class NotacionPolaca {

	public static String infijaaPosfija(String formula) {
		Stack<Character> pila = new Stack<>();
		StringBuilder result = new StringBuilder();
		String operadores = "^*/+-()";
		for(int i = 0; i < formula.length(); i++) {
			//Si es operando, pasarlo a la expresión postfija
			if(!operadores.contains(Character.toString(formula.charAt(i)))) { 
				result.append(formula.charAt(i));
			}
			//Si el operador es un parentecis derecho
			else if(formula.charAt(i) == ')') {
				pasoParentDerecho(formula.charAt(i),pila,result);
			}
			//Si es un operador distinto de parentecis derecho
			//Si la pila esta vacia o no se encarga el metodo
			else {
				pasoPilaNoVacia(formula.charAt(i),pila,result);
			}
		}
		while(!pila.empty()) {
			result.append(pila.pop());
		}
		return result.toString();
	}
	
	public static void pasoParentDerecho(char op, Stack<Character> pila, StringBuilder result) {
		// Sacar el operador cima y pasarlo a la expresión postfija
		result.append(pila.pop());
		//Si el nuevo operador cima es paréntesis izquierdo, suprimir el elemento cima.
		if(!pila.empty() && pila.peek() == '(') {
			pila.pop();
		}
		//Si la cima no es paréntesis izquierdo, volver a 4.1.
		else if(!pila.empty() && pila.peek() != '(') {
			pasoParentDerecho(op, pila, result);
		}
	}
	
	public static void pasoPilaNoVacia(char op, Stack<Character> pila, StringBuilder result) {
		if(pila.empty()) { //Si la pila está vacía, meterlo en la pila. Repetir a partir de 1. 
			pila.push(op);
		}
		//Prioridad afuera mayor adentro
		else if(prioridadAfueraPolaca(op) > prioridadAdentroPolaca(pila.peek())){
			pila.push(op);
		}
		//Prioridad adentro mayor que afuera
		else {
			result.append(pila.pop());
			pasoPilaNoVacia(op, pila, result);
		}
	}
	
	
	
	public static int prioridadAfueraPolaca(char r) {
		if(r == '^') {
			return 4;
		}else if(r == '*' || r == '/') {
			return 2;
		}else if(r == '+' || r == '-') {
			return 1;
		}else {
			return 5;
		}
	}
	
	public static int prioridadAdentroPolaca(char r) {
		if(r == '^') {
			return 3;
		}else if(r == '*' || r == '/') {
			return 2;
		}else if(r == '+' || r == '-') {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static Double evaluarPostFija(String expresion) {
		Stack<Double> pila = new Stack<>();
		String operadores = "^*/+-()";
		for (int i = 0; i < expresion.length(); i++) {
			//Si el elemento es un operando, meterlo en la pila
			if(!operadores.contains(Character.toString(expresion.charAt(i)))) { 
				pila.push(Double.valueOf(Character.toString(expresion.charAt(i))));
			}
			//Si el elemento es un operador
			else {
				double a =  pila.pop();
				double b =  pila.pop();
				if(expresion.charAt(i) == '^') {
					pila.push(Math.pow(b, a));
				}
				else if(expresion.charAt(i) == '*') {
					pila.push(a*b);
				}
				else if(expresion.charAt(i) == '/') {
					pila.push(b/a);
				}
				else if(expresion.charAt(i) == '+') {
					pila.push(a+b);
				}
				else if(expresion.charAt(i) == '-') {
					pila.push(b-a);
				}
			}
		}
		//Devolver el ultimo valor de la pila
		return pila.pop();
	}
	
	public static void main(String[] args) {
		String op = "a*(b+c-(d/e^f)-g)-h";
		String op1 = "2*(4+5-(1/3^2)-7)-8";
		System.out.println(infijaaPosfija(op));
		System.out.println(evaluarPostFija(infijaaPosfija(op1)));
	}
}
