import rx.Observable;
import rx.functions.Func2;

import java.util.ArrayList;

public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Jose", 10));
        personas.add(new Persona("Juan", 15));
        personas.add(new Persona("Miguel", 20));
        personas.add(new Persona("Lilian", 30));
        personas.add(new Persona("Steve", 19));
        personas.add(new Persona("Pablo", 12));
        personas.add(new Persona("Mario", 44));
        personas.add(new Persona("Fabiola", 20));
        personas.add(new Persona("Denis", 22));
        personas.add(new Persona("Max", 10));
        personas.add(new Persona("Rodriguez", 20));

        Observable observablepersona
                = Observable
                .from(personas.toArray())
                .map((result) -> {
                    Persona persona = (Persona) result;
                    return persona.getEdad();
                })
                .reduce(
                        new Func2<Integer, Integer, Integer>() {
                            @Override
                            public Integer call(Integer anterior, Integer actual) {
                                if (actual <= anterior) {

                                } else {
                                    anterior = actual;
                                }
                                return anterior;
                            }
                        }
                );
        observablepersona.subscribe((verificador) -> {
            System.out.println(" " + "La edad mayor es : " + verificador);
        });

    }

}
