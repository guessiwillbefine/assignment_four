### Assignment 4
"Розробити веб-застосунок з функцією автентифікації.<br>
Повинна бути сторінка, на якій користувач вводить логін і пароль, та кнопка "Login".<br>
Якщо користувач не вводить хоча б одне з цих полів або вони неправильні, користувачу відображається та сама сторінка з повідомленням про помилку..<br>
Якщо користувач вводить логін-пароль вірно, то він потрапляє на сторінку привітання.<br>
На сторінці привітання відображається системне меню, в якому є 2 пункти - перехід на сторінку зі списком користувачів і "Logout"..<br>
На сторінці зі списком користувачів відображаються в статичному вигляді всі наявні в системі користувачі у вигляді таблиці (їх логіни і імена, але без паролів)..<br>
Сторінка привітання і сторінка зі списком користувачів повинні бути доступні лише "залогіненим" користувачам (побачити їх, не ввівши правильній логін-пароль, повинно бути неможливо).<br>
При виборі "Logout" користувач потрапляє на сторінку входу і повинен вводити логін-пароль заново."

### Endpoints:
(GET)  http://localhost:8080/auth - get login page
(GET)  http://localhost:8080/auth/login - login
(POST) http://localhost:8080/auth/registration - get registration page
(POST) http://localhost:8080/auth/registration - registration
(GET)  http://localhost:8080/main - main page, access only if authenticated
(POST) http://localhost:8080/main/logout - logout method (clears users cookie)