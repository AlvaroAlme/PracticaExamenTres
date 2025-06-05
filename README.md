
## 🧠 **Examen Práctico de Programación Orientada a Objetos en Java**

### **Contexto del ejercicio**

Vas a desarrollar una pequeña aplicación de gestión para una **plataforma de venta de productos digitales y físicos**, incluyendo libros, revistas y ebooks. Cada producto puede tener descuentos dinámicos y algunos productos son descargables.

----------

### **Requisitos**

----------

### **1. Jerarquía de Clases**

#### a) Crea una clase abstracta `Producto` con:

-   `String codigo`
    
-   `String titulo`
    
-   `double precioBase`
    
-   `List<String> etiquetas`
    

Métodos:

-   Constructor
    
-   `abstract double calcularPrecioFinal();`
    
-   `boolean tieneEtiqueta(String etiqueta)`
    
-   `String toString()` que muestre tipo de producto, código, título, precio base, precio final y etiquetas.
    

----------

### **2. Subclases de Producto**

#### a) `Libro` (extiende Producto)

-   Atributos:
    
    -   `String autor`
        
    -   `int paginas`
        

**Regla de precio final:**

-   Si tiene más de 600 páginas y etiqueta `"premium"`, se incrementa el precio base en un 10%.
    

#### b) `Revista`

-   Atributos:
    
    -   `int numero`
        
    -   `String mes`
        

**Regla de precio final:**

-   Si contiene la etiqueta `"oferta"` se descuenta un 15%.
    

#### c) `EBook`

-   Atributos:
    
    -   `double tamanioMB`
        

**Regla de precio final:**

-   Aplica un descuento del 25%, y si tiene etiqueta `"nuevo"`, solo el 10%.
    

----------

### **3. Interfaces**

Define una interfaz `Descargable` con:

```java
void descargar();

```

Solo `EBook` implementa `Descargable`.

----------

### **4. Colecciones y Polimorfismo Avanzado**

En la clase principal `TiendaDigitalApp`, haz lo siguiente:

-   Lee un archivo `productos.csv` (formato explicado más abajo) y genera una colección de productos (`Map<String, List<Producto>>`), agrupados por tipo: `"Libro"`, `"Revista"`, `"EBook"`.
    
-   Muestra para cada grupo:
    
    -   Número total de productos
        
    -   Precio promedio
        
    -   El más caro y el más barato (usando `stream().max()` y `stream().min()`)
        
-   Recorre todos los productos y:
    
    -   Muestra el `toString()`
        
    -   Si es `Descargable`, llama a `descargar()`
        

----------

### **5. Archivo de Entrada**

Archivo `productos.csv`, con el siguiente formato por línea:

```
Libro;L001;El Quijote;25.99;autor=Don Quijote;paginas=900;etiquetas=premium,clasico
Revista;R010;Ciencia Hoy;4.50;numero=10;mes=Marzo;etiquetas=oferta,ciencia
EBook;E100;Java Moderno;15.00;tamanioMB=12.5;etiquetas=nuevo,programacion

```

Deberás parsear el archivo y construir cada tipo de producto correctamente.

----------

### **6. Extras Opcionales para Nota Adicional**

-   Permite buscar productos por etiqueta desde consola (ej. `"premium"`) y mostrarlos con stream+filter.
    
-   Ordena todos los productos por precio final y guárdalos en un archivo `ordenados.txt`.
   