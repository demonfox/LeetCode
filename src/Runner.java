import java.lang.reflect.InvocationTargetException;

public class Runner {
    public static void main(String[] args) {
        Run("PathSumII");
    }

    private static void Run(String problem) {
        String methodName = "Run";

        try {
            Class<?> cl = Class.forName(problem);
            Class<?> arguments[] = new Class[] {};
            java.lang.reflect.Method objMethod 
                = cl.getMethod(methodName, arguments);
            objMethod.invoke(null);
        } catch (ClassNotFoundException e) {
            System.out.println("No such class defined: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            System.out.println("\"Run\" method is not defined for this class: "
                    + e.getMessage());
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
    }
}
