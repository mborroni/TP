## Consultora de imagen y gestión política
### Descripción de la organización
Cooperativa conformada por estudiantes de ciencias sociales y estudiantes de informática.
Ofrece dos servicios: análisis de imagen y análisis de agenda política. 
Para brindar estos servicios recurre a las técnicas de procesamiento de grandes volúmenes de datos (“Big Data”) provenientes de redes sociales, a la observación de programas de televisión (aire y cable) y relevamiento de diarios y revistas (digitales y físicos).
### Alcance
En esta primer versión el sistema contempla el análisis de agenda política.
### Objetivo
Construir progresivamente un sistema propietario que integre los datos provenientes de distintas fuentes, sintetizarlos y analizarlos.
### Pequeño relevamiento
La consultora destina parte del personal para realizar seguimiento de programas de televisión y diarios. Entre las personas afectadas a la tarea (a partir de ahora operadores) se reparten los temas de actualidad que requieren seguimiento. Durante un período de tiempo registran datos relacionados al tratamiento de estos temas en la televisión y los diarios. Una vez concluido el período pactado genera un informe.
Por otro lado la consultora contrata una empresa que le provee la información que circula en las redes sociales sobre estos temas. Esta información, que en general es el impacto del tema en la opinión pública,  es anexada al informe.
Por último, algunos/as especialistas cierra el informe con una conclusión y el mismo es enviado al cliente que contrató el servicio.
### Requerimientos funcionales
1. El sistema permite crear, eliminar y modificar temas. El tema tiene un código alfanumérico único de seis caracteres, una palabra clave, una descripción y un período de seguimiento (fecha desde y hasta). Opcional: el tema puede tener varias palabras claves asociadas.
1. El sistema permite listar todos los temas. 
1. El sistema permite al usuario buscar temas por similitud de palabra clave. Por ej.: temas que empiecen con “qwer”.
1. El seguimiento de un tema es siempre a través de todo los medios.
1. El sistema permite a un operador cargar el seguimiento de un tema. Los datos que ingresa el operador son: el nombre de operador, minutos de televisión destinados al tema en promedio por día, cantidad de minutos destinados al tema en horario central, cantidad de notas en diarios y cantidad de tapas de diario. Por último el operador carga una apreciación al respecto del tratamiento del tema.
1. Los nombres posibles de operador están predefinidos en el sistema.
1. El operador puede consultar para un tema en particular la información que hay registrada de seguimiento.
1. El reporte de seguimiento de un tema, contiene los datos que ingresó el operador y los cálculos del sistema.
1. El sistema calcula e informa si el tema tuvo trascendencia. Se considera que tuvo trascendencia si:
    * Para los medios tradicionales (televisión y diarios): se considera trascendente un tema si tuvo al menos una tapa diario, si fue tratado en horario central en algún programa televisivo y si los minutos promedios por día superan los 60 minutos.
    * Para las redes sociales: si la cantidad de publicaciones son superiores a las 5000 y las réplicas 15000.
1. Los datos de la redes sociales que contempla el sistema son: la cantidad de publicaciones en apoyo, en rechazo y neutrales, la cantidad de réplicas, la cantidad de “me gusta” sobre las publicaciones anteriormente mencionadas.
1. El sistema calcula e informa si en la redes sociales el tratamiento del tema fue en apoyo o no. Se considera que fue en apoyo si las publicaciones en apoyo por los “me gusta” en apoyo superan en un 20 % las publicaciones en rechazo por los “me gusta” en rechazo.
1. El operador puede modificar los datos del seguimiento de un tema.
### Requerimientos no funcionales
1. La aplicación constará de un menú. El cual tendrá, al menos, los elementos: Archivo -> Salir y Ayuda -> Aceca de.
1. La forma de representar gráficamente las listas es JTable.
1. Al momento de listar temas, los temas que aún no tienen seguimiento serán resaltados. Por ej.: la fila coloreada de violeta.
1. En la carga de seguimiento, los nombres posibles de operadoradores estarán disponibles en un combo (JCombo).
1. Las fechas serán manejadas con las clases que hay en el paquete java.time.*
Recomendado: componente visual para manejar fechas en Swing https://toedter.com/jcalendar/
1. Los nombres de los operadores posibles estarán almacenados en una tabla en la base de datos relacional.
### Consideraciones
1. Los datos de las redes sociales estarán disponibles en una tabla en la base de datos.
1. No es necesario implementar algún tipo seguridad en el sistema, por ej.: inicio de sesión.

