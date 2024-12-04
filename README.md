# API-Reconocimientos-Extra

## **Servicio 2: Reconocimientos Extra**

### **Descripción**
Muchas empresas han decidido ofrecer beneficios a sus colaboradores a través de sus propias plataformas. Con el fin de facilitar este proceso, implementaremos un **servicio de recomendaciones de colaboradores** que cumplirá con los parámetros solicitados por las empresas. Este servicio permitirá identificar a los colaboradores que merecen ser reconocidos, basándose en los siguientes criterios:

### **Parámetros Solicitados por las Empresas**
Las empresas especificarán los siguientes requisitos para seleccionar a los colaboradores:

1. **Cantidad mínima de puntos** requeridos.
2. **Cantidad mínima de donación de viandas** realizada en el último mes.
3. **Cantidad máxima de colaboradores** a ser incorporados en la plataforma externa.

### **Condiciones de Selección**
- El sistema seleccionará únicamente a aquellos colaboradores que **cumplan con todas las condiciones** solicitadas.
- Si no se alcanza la cantidad máxima de colaboradores, se devolverán **todos los colaboradores que cumplan con los requisitos**, incluso si el número es menor al solicitado.

### **Resultado**
El sistema devolverá una lista de colaboradores recomendados para ser reconocidos por las empresas, junto con el **puntaje** que obtuvo cada uno hasta el momento.
