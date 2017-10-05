/**
 *
 */
package com.sean.testtpg.q3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sean.testtpg.q2.SortStudent;
import com.sean.testtpg.q2.SortStudentImpl;

/**
 * @author sean
 *
 */
public class MethodTimerByReflect {

	public static void main(String[] args){
		getMethodConsumedTime(Math.class, "random",null,null);

		Double[] d = {2.0,3.0};
		Class<?>[] dtype = {double.class, double.class};
		getMethodConsumedTime(Math.class, "pow", d, dtype);
		
		SortStudent sortStudent = new SortStudentImpl();
		
		String[] s = {"src\\main\\resource\\student.txt"};
		getMethodConsumedTime(sortStudent,"getStudentsFromFile",s,null);
		getMethodConsumedTime(sortStudent,"sort",null,null);
		getMethodConsumedTime(sortStudent,"displayStudents",null,null);

	}
	
	/**
	 * get method running time in nano-second
	 * 
	 * @param obj : the object of a class	 * 
	 * @param methodName
	 * @param parameters : null for none parameters
	 * @param parameterTypes : for null parameterTypes, will get class type from parameters
	 * * but will transform the wrap classes, e.g. int.class to Integer.class
	 * @return
	 */

	public static long getMethodConsumedTime(Object obj, String methodName,  
			Object[] parameters, Class<?>[] parameterTypes ){

		long consumedTime = 0L;
		if(obj == null || methodName == null || methodName.trim().equals("")){
			// for null object or method;
			System.out.println("null method or null object");
			return consumedTime;
		}
		
		Class<?> cls = null;
		if(obj instanceof Class<?>){
			// for static method
			cls = (Class<?>) obj;
		} else {
			cls = obj.getClass();
		}
		

		Method method =null;
		
		long startTime = 0L;
		try {
			if(parameters == null || parameters.length==0 ){
				// for method does not have parameters
				method = cls.getDeclaredMethod(methodName);
				startTime = System.nanoTime();
				method.invoke(obj);
			} else{
				if(parameterTypes == null){
					parameterTypes = new Class<?>[parameters.length];
					int i=0;
					for(Object parameter:parameters){					
						parameterTypes[i] = parameter.getClass();
						i++;
					}
				}
				method = cls.getDeclaredMethod(methodName, parameterTypes);
				startTime = System.nanoTime();
				method.invoke(obj, parameters);
			}
			 
			consumedTime = System.nanoTime()-startTime;
			
			System.out.println("The time consumed of method: "+obj.toString()+"."+methodName
					+" is: "+consumedTime +" nanoseconds ("+Math.round(consumedTime/(1E6))+" milliseconds).");
			
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			System.out.println("class: "+cls.getName()+" does not have this method:" + methodName + " with the parameters.");
			e.printStackTrace();
		}
		
		return consumedTime;
	}
}
