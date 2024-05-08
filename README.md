# Homebankin Application

## Configuración

#### ClientDTO
Representa la información que se mostrará de la entidad Client en las peticiones. Posee los siguientes campos: 

id (long): Identificador del cliente

firstName (string): Nombre del cliente

lastName (string): Apellido del cliente

email (string): Correo del cliente

accounts (List < AccountDTO >): Lista de las cuentas que posee el cliente

loans (List < ClientLoanDTO >): Lista de los préstamos del cliente

cards (List < CardDTO >): Lista de las tarjetas que posee el cliente

#### AccountDTO
Reperesenta la información que se mostrará de la entidad Account en las peticiones. Posee los siguientes campos:

id (long): Identificador de la cuenta

number (string): Número de la cuenta

date (LocalDate): Fecha de creación de la cuenta

balance (double): Balance de la cuenta

transactions (List < TransactionDTO >): Lista de transacciones realizadas con la cuenta
