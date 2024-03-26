Documentacion Codigo

GenerateInfoFiles.java
Método main: Este método sirve y es el punto de entrada de la clase GenerateInfoFiles. Aquí llamamos a los métodos para generar los archivos planos de ventas de vendedores, información de productos y de vendedores. Si ocurre algún error durante el proceso, se captura y muestra un mensaje de error.
Método createSalesMenFile: Este método crea un archivo plano pseudoaleatorio con información de ventas de un vendedor. Toma como argumentos la cantidad de ventas (randomSalesCount), el nombre del archivo (name) y el ID del vendedor (id). Se utiliza un bucle para generar las ventas aleatorias para cada vendedor.
Método createProductsFile: Es parecido al método anterior, pero este método crea un archivo plano con información de productos. Toma como argumentos la cantidad de productos (productsCount) y el nombre del archivo (name). Utiliza un bucle para generar la información de productos de manera pseudoaleatoria.
Método createSalesManInfoFile: Este método crea un archivo plano con información de los vendedores. Toma como argumentos la cantidad de vendedores (salesmanCount) y el nombre del archivo (name). Genera nombres y apellidos aleatorios para los vendedores y los guarda en el archivo.

Main.java
Método main: Punto de entrada de la clase Main. Aquí se invoca el método processSalesData, que realiza el procesamiento de los datos de ventas de acuerdo con los requisitos especificados.
Método processSalesData: Este método realiza el procesamiento de los datos de ventas de acuerdo con los requisitos especificados:

Lee la información de ventas de vendedores, información de vendedores y de productos desde los archivos.
Calcula la cantidad total de dinero recaudada por cada vendedor y la cantidad de cada producto vendido.
Ordena los vendedores por la cantidad total de dinero recaudada de forma descendente.
Escribe la información de los vendedores ordenados en un archivo CSV.
Ordena los productos por la cantidad vendida de forma descendente y escribe la información en otro archivo CSV.
