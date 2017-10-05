/**
 *
 */
package com.sean.testtpg.q3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.sean.testtpg.q2.SortStudent;
import com.sean.testtpg.q2.SortStudentImpl;

/**
 * must use an interface
 * 
 * @author sean
 *
 */
public class MethodTimerByProxy{
	
	public static void main(String[] args){

		SortStudent sortStudent =  (SortStudent) MethodTimerByProxy.getInstanct(new SortStudentImpl());
		
		sortStudent.getStudentsFromFile("src\\main\\resource\\student.txt");
		
		sortStudent.sort();
		
		sortStudent.displayStudents();
		
	}
	
	public static Object getInstanct(Object obj){

		Object proxy = null;

		proxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler(){
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				
				long startTime = System.nanoTime();
				
				method.invoke(obj, args);
				
				long consumedTime = System.nanoTime()-startTime;
				
				System.out.println("The time consumed of method: "+obj.getClass().toString()+"."+method.getName()
						+" is: "+consumedTime +" nanoseconds ("+Math.round(consumedTime/(1E6))+" milliseconds).");

				return null;
			}

			
		});

		return proxy;
	}

}
