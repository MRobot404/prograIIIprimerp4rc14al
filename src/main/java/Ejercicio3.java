import rx.Observable;
import rx.functions.Func2;
import rx.observables.MathObservable;

import javax.swing.*;
import java.util.ArrayList;

/*
 * @author Oscar Escobar
 */
public class Ejercicio3 {

    public static void main(String[] args) {
        ArrayList<Numero> numeros = new ArrayList<>();
        numeros.add(new Numero(2));
        numeros.add(new Numero(5));
        numeros.add(new Numero(6));
        numeros.add(new Numero(8));
        numeros.add(new Numero(10));
        numeros.add(new Numero(35));
        numeros.add(new Numero(2));
        numeros.add(new Numero(10));

        Observable<Numero> numeroObservable = Observable.from(numeros);

        MathObservable
                .from(numeroObservable)
                .averageInteger(Numero::getNumero)
                .subscribe((promedio) -> {
                    System.out.println("Promedio " + promedio + " \n");
                });
        Observable observablenumero
                = Observable
                .from(numeros.toArray())
                .map((result) -> {
                    Numero numero = (Numero) result;
                    return numero.getNumero();
                })
                .reduce(
                        new Func2<Integer, Integer, Integer>() {
                            @Override
                            public Integer call(Integer anterior, Integer actual) {
                                if (actual == 10) {
                                    System.out.println(actual + " Es igual a 10");
                                } else if (actual >= 10) {
                                    System.out.println(actual + " Es mayor a 10");
                                } else {
                                    System.out.println(actual + " Es menor a 10");
                                }
                                return actual;
                            }
                        });
        observablenumero.subscribe((verificador) -> {
            System.out.println("\n");
        });

        Observable observablenumerosumatoria =
                Observable
                        .from(numeros.toArray())
                        .map((result) -> {
                            Numero numero = (Numero) result;
                            return numero.getNumero();
                        })
                        .reduce(
                                new Func2<Integer, Integer, Integer>() {
                                    @Override
                                    public Integer call(Integer acumulador, Integer actual) {
                                        return acumulador+actual;
                                    }
                                }
                        );
                observablenumerosumatoria.subscribe((sumatoria) ->{
                    System.out.println(""+
                            " Sumatoria: "+sumatoria+" \n");
                });
    }

}
