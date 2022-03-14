import rx.Observable;
import rx.functions.Func2;

import java.util.ArrayList;
/*
 * @author Oscar Escobar
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        ArrayList<Consola> consolas = new ArrayList<>();
        consolas.add(new Consola("ps4", 300));
        consolas.add(new Consola("gamecube", 300));
        consolas.add(new Consola("external disk", 200));
        consolas.add(new Consola("laptop", 800));
        consolas.add(new Consola("vr", 230));

        Observable observableconsola
                = Observable
                .from(consolas.toArray())
                .map((result) -> {
                    Consola consola = (Consola) result;
                    return consola.getPrecio();
                })
                .reduce(
                        new Func2<Integer, Integer, Integer>() {
                            @Override
                            public Integer call(Integer acumulador, Integer actual) {
                                return acumulador + actual;
                            }
                        }
                );
        observableconsola.subscribe((sumatoria) -> {
            System.out.println("Sumatoria de los items: " + sumatoria + "\n");

        });
        Observable observableconsola2
                = Observable
                .from(consolas.toArray())
                .map((result) ->{
                    Consola consola = (Consola) result;
                    return consola.getPrecio();
                })
                .reduce(
                        new Func2<Integer, Integer, Integer>() {
                            @Override
                            public Integer call(Integer anterior, Integer actual) {
                              if (actual <= anterior){

                              }else{
                                  anterior=actual;
                              }
                              return anterior;
                            }
                        }
                );
        observableconsola2.subscribe((verificador) ->{
            System.out.println("Precio máximo del listado de producto: "+verificador);
        });

    }
}
