package _08_Generics;

//interface that uses one or more type parameters.
//Just like a generic class:

interface Container<T>{                   // T is a type parameter.
    void setData(T data);
    T getData();
}

class StringContainer implements Container<String>{                // type fixed by the implementing class.
    private String data;

    public void setData(String data){
        this.data = data;
    }

    public String getData(){
        return data;
    }
}

// Note: Instead of fixing the type, the implementing class can remain generic
class Storage<T> implements Container<T>{
    private T data;

    public void setData(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }
}



public class _02_GenericInterfaces {
    public static void main(String[] args) {
        // Using specific implementation
        StringContainer stc = new StringContainer();
        stc.setData("Sneha");
        System.out.println(stc.getData());


        // Using Generic implementation
        Storage<String> st = new Storage<>();
        st.setData("Daksh");
        System.out.println(st.getData());

        Storage<Integer> st1 = new Storage<>();
        st1.setData(1);
        System.out.println(st1.getData());
    }
}
