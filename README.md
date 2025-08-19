<h1>DESAFIO FORO HUB</h1>
<br>
Dentro de este sistema, se simulan algunas funciones disponibles dentro de un foro utilizando bases de datos, consultas API a través de JSON, y la plataforma de pruebas Insomnia.  Estas funciones incluyen una aproximación del inicio de sesión con la generación de un token de acceso para ingresar al resto de funciones, además de la creación de tópicos, la visualización de todos los actualmente activos, su modificación, eliminación lógica y una vista detallada de un tópico en particular.
<br>
<h2>Validación de usuario</h2>
<h3>Función</h3>
Utilizando Insomnia, una vez el sistema se inicie, es posible enviar una solicitud a la dirección de login (por defecto http://localhost:(puerto)/login) siempre que exista un usuario dentro de la base de datos, una vez hecho esto, se generara un token JWT el cual se deberá utilizar para hacer uso del resto de las funciones por razones de seguridad. 

<h2>Ingreso de tópico</h2>
<h3>Función</h3>
Una vez se tenga acceso al resto de funciones utilizando el token para acceder, será posible ingresar tópicos desde Insomnia enviando los datos necesarios al sistema Java dentro de formato JSON, el sistema recibirá la información y procederá a enviarla a la base de datos mediante Jpa y solicitudes POST.

<h2>Lista de tópicos</h2>
<h3>Función</h3>
Mediante una solicitud GET, se podrá recibir dentro de Insomnia una lista de cada tópico actualmente dentro del sistema que se encuentre activo, es decir que no haya sido eliminado lógicamente de la base de datos.

<h2>Tópico detallado</h2>
<h3>Función</h3>
Igualmente con GET, y en conjunto al uso de Insomnia en la barra de direcciones que posee esta, será posible solicitar la visualización de un único tópico en base al id provisto desde el programa.

<h2>Actualización de tópico</h2>
<h3>Función</h3>
Es posible editar el titulo y el mensaje del tópico mediante la solicitud PUT, y estos cambios serán mostrados dentro de Insomnia para poder comprobar que se realizaron correctamente.

<h2>Eliminación de tópico</h2>
<h3>Función</h3>
Utilizando la solicitud DELETE se hará una eliminación lógica de un tópico provisto desde Insomnia en base al id elegido.  Por eliminación lógica se entiende que este tópico no será completamente removido, sino que será catalogado como inactivo e incapaz de ser visualizado dentro de la lista de tópicos.
