/*
* Somando valores sem laços
* Fonte: https://dev.to/zanfranceschi/desafio-calculo-em-estruturas-aninhadas-sem-lacos-2311
*
* Artigo do Jeff Coelhos no qual encontrei o desafio
* https://computaria.gitlab.io/blog/2022/09/09/soma-valores-sem-loops
*
*/

/*
{
    "compras": [
    {
        "data": "2022-01-01",
        "produtos": [
        {
            "cod": "a",
            "qtd": 2,
            "valor_unitario": 12.24
        },
        {
            "cod": "b",
            "qtd": 1,
            "valor_unitario": 3.99
        },
        {
            "cod": "c",
            "qtd": 3,
            "valor_unitario": 98.14
        }
        ]
    },
    {
        "data": "2022-01-02",
        "produtos": [
        {
            "cod": "a",
            "qtd": 6,
            "valor_unitario": 12.34
        },
        {
            "cod": "b",
            "qtd": 1,
            "valor_unitario": 3.99
        },
        {
            "cod": "c",
            "qtd": 1,
            "valor_unitario": 34.02
        }
        ]
    }
    ]
}
*/

/*
* Produto
*  - codigo: String
*  - quantidade: Integer
*  - valor: Double
*
* Compra
*  - data: String
*  - produtos: List<Produto>
*
* compras: List<Compra>
*/

import java.util.List;

record Produto(String codigo, Integer quantidade, Double valor) {}

record Compra(String data, List<Produto> produtos) {}

public class App {
    public static void main(String[] args) {
        List<Compra> compras = List.of(
            new Compra(
                "2022-01-01",
                List.of(
                        new Produto("a", 2, 12.34),
                        new Produto("b", 1, 3.99),
                        new Produto("d", 3, 98.14)
                )
            ),
            new Compra(
                "2022-01-02",
                List.of(
                        new Produto("a", 6, 3.99),
                        new Produto("b", 1, 12.34),
                        new Produto("c", 1, 34.02)
                )
            )
        );

        /*
         * Resolvendo essa brincadeira
         * Valores: (12.34 * 3) + (3.99 * 7) + (98.14 * 3) + (34.02 * 1)
         * Resultado: 393.39
         */
        compras
            .stream()
            .flatMap(
                c -> c.produtos().stream()
            )
            .map(
                p -> p.valor() * p.quantidade()
            )
            .reduce(
                (a0, a1) -> a0 + a1
            )
            .get();
    }
}
