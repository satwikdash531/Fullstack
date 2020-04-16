package com.annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@interface Getter
{
	String gm() default ""; 
	
}	
class Order
{
	private double price;
	@Getter
	public double getPrice()
	{
		return this.price;
	}
	@Getter
	public double Foo()
	{
		return this.price;
	}
	@Getter
	public void display()
	{
		System.out.println("This is not a Getter method!");
	}
}
class OrderTest
{
	public static void main(String [] args) throws Exception
	{
		Class c = Class.forName("com.annotation.Order");
		Method m[]=c.getDeclaredMethods();
		for(int i=0;i<m.length;i++)
		{
			Method myMethod=m[i];
			Annotation annotations[]=myMethod.getAnnotations();
			for(int j=0;j<annotations.length;j++)
			{
				String s=annotations[j].annotationType().getName();
				if(s.equals("com.annotation.Getter"))
				{
					String temp=m[i].getName();
					String temp1=temp.substring(3);
					temp1=temp1.toLowerCase();
					Field fields[] = c.getDeclaredFields();
					for(int k=0;k<fields.length;k++)
					{
						if((fields[k].getName()).equals(temp1))
							System.out.println("@Getter Annotation is Properly used in "+ temp1 + " Method");
						else
							System.out.println("@Getter Annotation is Not Properly used ");
					}	
				}
			}
		}
	}
}

	