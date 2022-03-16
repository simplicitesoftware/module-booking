<!--
 ___ _            _ _    _ _    __
/ __(_)_ __  _ __| (_)__(_) |_ /_/
\__ \ | '  \| '_ \ | / _| |  _/ -_)
|___/_|_|_|_| .__/_|_\__|_|\__\___|
            |_| 
-->
![](https://docs.simplicite.io//logos/logo250.png)
* * *

`Booking` module definition
===========================



`BookBookingsHistoric` business object definition
-------------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `row_ref_id` link to **`BookBookings`**                      | id                                       | yes*     |           |          | Record row ID                                                                    |
| `row_idx`                                                    | int(11)                                  | yes*     | yes       |          | History record index                                                             |
| `created_by_hist`                                            | char(100)                                | yes*     |           |          | Created by                                                                       |
| `created_dt_hist`                                            | datetime                                 | yes*     | yes       |          | Created date                                                                     |
| `BookBookings_BookUsers_id` link to **`BookUsers`**          | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `BookBookings_BookUsers_id.usr_title`_                 | _enum(5) using `USER_TITLE` list_        |          |           | yes      | _Title_                                                                          |
| _Ref. `BookBookings_BookUsers_id.usr_last_name`_             | _char(50)_                               |          |           | yes      | _Last name_                                                                      |
| _Ref. `BookBookings_BookUsers_id.usr_first_name`_            | _char(50)_                               |          |           | yes      | _First name_                                                                     |
| _Ref. `BookBookings_BookUsers_id.bookBookusersEmail`_        | _email(100)_                             |          |           |          | -                                                                                |
| `bookBookbookingsDate`                                       | date                                     | yes*     |           |          | -                                                                                |
| `bookBookbookingsHour`                                       | time                                     | yes*     |           |          | -                                                                                |
| `bookBookbookingsStartDate`                                  | datetime                                 | yes      | yes       |          | -                                                                                |
| `bookBookbookingsEndDate`                                    | datetime                                 | yes      | yes       |          | -                                                                                |
| `bookBookbookingsPaymentTDate`                               | date                                     |          |           |          | -                                                                                |
| `bookBookbookingsAmountDate`                                 | date                                     |          |           |          | -                                                                                |
| `bookBookbookingsPaymentDone`                                | boolean                                  |          | yes       |          | -                                                                                |
| `bookBookbookingsComments`                                   | html(2000)                               |          | yes       |          | -                                                                                |
| `bookBookbookingsStatut`                                     | enum(2) using `BOOKBOOKBOOKINGSSTATUT` list |          | yes       |          | -                                                                                |
| `bookBookbookingsRoomNumber`                                 | enum(100) using `BOOKBOOKBOOKINGSROOMNUMBER` list | yes      | yes       |          | -                                                                                |
| `bookBookbookingsGuestNumber`                                | enum(2) using `BOOKBOOKBOOKINGSROOMNUMBER` list |          | yes       |          | -                                                                                |

### Lists

* `USER_TITLE`
    - `MR` 
    - `MRS` 
    - `MS` 
* `BOOKBOOKBOOKINGSSTATUT`
    - `EA` En attente
    - `TR` Traitée
    - `Cl` Clôturée
* `BOOKBOOKBOOKINGSROOMNUMBER`
    - `1` 1
    - `2` 2
    - `3` 3
    - `4` 4
    - `5` 5
    - `6` 6
    - `7` 7
    - `8` 8
    - `9` 9
    - `10` 10

`BookEquRoom` business object definition
----------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `bookEquroomEquId` link to **`BookRoomEquipment`**           | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `bookEquroomEquId.bookEquCode`_                        | _char(20)_                               |          |           |          | -                                                                                |
| `bookEquroomRoomId` link to **`BookRoom`**                   | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `bookEquroomRoomId.bookRoomCode`_                      | _char(20)_                               |          |           |          | -                                                                                |

`BookRoomBookRoomService` business object definition
----------------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `app_BookRoom_fk` link to **`BookRoom`**                     | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `app_BookRoom_fk.bookRoomCode`_                        | _char(20)_                               |          |           |          | -                                                                                |
| `app_BookRoomService_fk` link to **`BookRoomService`**       | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `app_BookRoomService_fk.bookRservCode`_                | _char(20)_                               |          |           |          | -                                                                                |

`BookRoomEquipment` business object definition
----------------------------------------------

Room Equipements

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `bookEquLibell`                                              | text(255)                                | yes      | yes       |          | -                                                                                |
| `bookEquCode`                                                | char(20)                                 | yes*     | yes       |          | -                                                                                |

`BookPaymentMethod` business object definition
----------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `bookPaymCode`                                               | char(20)                                 | yes*     |           |          | -                                                                                |
| `bookPaymLibell`                                             | char(100)                                | yes      | yes       |          | -                                                                                |

`BookRoomService` business object definition
--------------------------------------------

Services in room

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `bookRservCode`                                              | char(20)                                 | yes*     | yes       |          | -                                                                                |
| `bookRservLibell`                                            | char(255)                                | yes      | yes       |          | -                                                                                |

`BookRoomType` business object definition
-----------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `bookRoomtypCode`                                            | char(20)                                 | yes*     | yes       |          | -                                                                                |
| `bookRoomtypType`                                            | text(100)                                | yes      | yes       |          | -                                                                                |

`BookRoom` business object definition
-------------------------------------

Booking rooms

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `bookRoomCode`                                               | char(20)                                 | yes*     | yes       |          | -                                                                                |
| `bookRoomLabel`                                              | char(255)                                | yes      | yes       |          | -                                                                                |
| `BookRoom_BookRoomType_id` link to **`BookRoomType`**        | id                                       |          | yes       |          | -                                                                                |
| _Ref. `BookRoom_BookRoomType_id.bookRoomtypCode`_            | _char(20)_                               |          |           |          | -                                                                                |
| _Ref. `BookRoom_BookRoomType_id.bookRoomtypType`_            | _text(100)_                              |          |           |          | -                                                                                |
| `bookRoomDesc`                                               | html(200)                                |          | yes       |          | -                                                                                |
| `bookRoomSuperficie`                                         | enum(10) using `BOOKROOMSUPERFICIE` list |          | yes       |          | -                                                                                |
| `bookRoomFloor`                                              | enum(2) using `BOOKROOMFLOOR` list       | yes      | yes       |          | -                                                                                |
| `bookRoomPhoto`                                              | image                                    |          | yes       |          | -                                                                                |
| `bookRoomPriceht`                                            | float(11, 2)                             |          | yes       |          | -                                                                                |

### Lists

* `BOOKROOMSUPERFICIE`
    - `12` 12 m2
    - `15` 15 m2
    - `17` 17 m2
    - `22` 22m2
* `BOOKROOMFLOOR`
    - `0` RDC
    - `1` 1er
    - `2` 2ème
    - `3` 3ème
    - `4` 4ème
    - `5` 5ème
    - `6` 6ème

`BookUsers` business object definition
--------------------------------------

Customers

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `usr_title`                                                  | enum(5) using `USER_TITLE` list          |          | yes       | yes      | Title                                                                            |
| `usr_last_name`                                              | char(50)                                 | yes      | yes       | yes      | Last name                                                                        |
| `usr_first_name`                                             | char(50)                                 | yes      | yes       | yes      | First name                                                                       |
| `usr_work_num`                                               | phone(20)                                |          | yes       | yes      | Work phone number                                                                |
| `usr_home_num`                                               | phone(20)                                |          | yes       |          | -                                                                                |
| `usr_cell_num`                                               | phone(20)                                | yes      | yes       | yes      | Mobile/cellular phone number                                                     |
| `usr_address1`                                               | char(100)                                | yes      | yes       | yes      | Address line 1                                                                   |
| `usr_address2`                                               | char(100)                                |          | yes       | yes      | Address line 2                                                                   |
| `usr_zipcode`                                                | char(10)                                 |          | yes       | yes      | Postal/ZIP code                                                                  |
| `usr_city`                                                   | char(50)                                 | yes      | yes       | yes      | City                                                                             |
| `usr_state`                                                  | char(50)                                 |          | yes       | yes      | State                                                                            |
| `usr_country`                                                | enum(20) using `COUNTRY` list            | yes      | yes       | yes      | Country                                                                          |
| `bookBookusersEmail`                                         | email(100)                               | yes*     | yes       |          | -                                                                                |
| `bookBookusersType`                                          | enum(3) using `BOOKBOOKUSERSTYPE` list   | yes      | yes       |          | -                                                                                |
| `bookUserGeoCoord`                                           | geocoords                                |          | yes       |          | -                                                                                |

### Lists

* `USER_TITLE`
    - `MR` 
    - `MRS` 
    - `MS` 
* `COUNTRY`
    - `FR` France
    - `UK` Royaume Uni
    - `ES` Espagne
    - `DE` Allemagne
    - `BE` Belgique
    - `CH` Suisse
    - `IE` Ireland
    - `CA` Canada
    - `US` Etats Unis
* `BOOKBOOKUSERSTYPE`
    - `CUS` Client
    - `ACC` Accompagnateur

`BookGuests` business object definition
---------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `bookBookusersType`                                          | enum(3) using `BOOKBOOKUSERSTYPE` list   | yes      | yes       |          | -                                                                                |

### Lists

* `BOOKBOOKUSERSTYPE`
    - `CUS` Client
    - `ACC` Accompagnateur

`BookBookings` business object definition
-----------------------------------------

Bookings of a customer

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `BookBookings_BookUsers_id` link to **`BookUsers`**          | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `BookBookings_BookUsers_id.usr_title`_                 | _enum(5) using `USER_TITLE` list_        |          |           | yes      | _Title_                                                                          |
| _Ref. `BookBookings_BookUsers_id.usr_last_name`_             | _char(50)_                               |          |           | yes      | _Last name_                                                                      |
| _Ref. `BookBookings_BookUsers_id.usr_first_name`_            | _char(50)_                               |          |           | yes      | _First name_                                                                     |
| _Ref. `BookBookings_BookUsers_id.bookBookusersEmail`_        | _email(100)_                             |          |           |          | -                                                                                |
| `bookBookbookingsDate`                                       | date                                     | yes*     |           |          | -                                                                                |
| `bookBookbookingsHour`                                       | time                                     | yes*     |           |          | -                                                                                |
| `bookBookbookingsStartDate`                                  | datetime                                 | yes      | yes       |          | -                                                                                |
| `bookBookbookingsEndDate`                                    | datetime                                 | yes      | yes       |          | -                                                                                |
| `bookBookbookingsPaymentTDate`                               | date                                     |          |           |          | -                                                                                |
| `bookBookbookingsAmountDate`                                 | date                                     |          |           |          | -                                                                                |
| `bookBookbookingsPaymentDone`                                | boolean                                  |          | yes       |          | -                                                                                |
| `bookBookbookingsComments`                                   | html(2000)                               |          | yes       |          | -                                                                                |
| `bookBookbookingsStatut`                                     | enum(2) using `BOOKBOOKBOOKINGSSTATUT` list |          | yes       |          | -                                                                                |
| `bookBookbookingsRoomNumber`                                 | enum(100) using `BOOKBOOKBOOKINGSROOMNUMBER` list | yes      | yes       |          | -                                                                                |
| `bookBookbookingsGuestNumber`                                | enum(2) using `BOOKBOOKBOOKINGSROOMNUMBER` list |          | yes       |          | -                                                                                |

### Lists

* `USER_TITLE`
    - `MR` 
    - `MRS` 
    - `MS` 
* `BOOKBOOKBOOKINGSSTATUT`
    - `EA` En attente
    - `TR` Traitée
    - `Cl` Clôturée
* `BOOKBOOKBOOKINGSROOMNUMBER`
    - `1` 1
    - `2` 2
    - `3` 3
    - `4` 4
    - `5` 5
    - `6` 6
    - `7` 7
    - `8` 8
    - `9` 9
    - `10` 10

`BookPayments` business object definition
-----------------------------------------

Bookings payments

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `BookPayments_BookBookings_id` link to **`BookBookings`**    | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `BookPayments_BookBookings_id.BookBookings_BookUsers_id`_ | _id_                                     |          |           |          | -                                                                                |
| _Ref. `BookPayments_BookBookings_id.bookBookbookingsDate`_   | _date_                                   |          |           |          | -                                                                                |
| _Ref. `BookPayments_BookBookings_id.bookBookbookingsHour`_   | _time_                                   |          |           |          | -                                                                                |
| _Ref. `BookBookings_BookUsers_id.usr_title`_                 | _enum(5) using `USER_TITLE` list_        |          |           | yes      | _Title_                                                                          |
| _Ref. `BookBookings_BookUsers_id.usr_last_name`_             | _char(50)_                               |          |           | yes      | _Last name_                                                                      |
| _Ref. `BookBookings_BookUsers_id.usr_first_name`_            | _char(50)_                               |          |           | yes      | _First name_                                                                     |
| _Ref. `BookBookings_BookUsers_id.bookBookusersEmail`_        | _email(100)_                             |          |           |          | -                                                                                |
| _Ref. `BookPayments_BookBookings_id.bookBookbookingsStartDate`_ | _datetime_                               |          |           |          | -                                                                                |
| _Ref. `BookPayments_BookBookings_id.bookBookbookingsEndDate`_ | _datetime_                               |          |           |          | -                                                                                |
| `bookPayPaymId` link to **`BookPaymentMethod`**              | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `bookPayPaymId.bookPaymCode`_                          | _char(20)_                               |          |           |          | -                                                                                |
| _Ref. `bookPayPaymId.bookPaymLibell`_                        | _char(100)_                              |          |           |          | -                                                                                |
| `bookPayAmount`                                              | float(10, 2)                             | yes      | yes       |          | -                                                                                |
| `bookPayComments`                                            | html(1000)                               |          | yes       |          | -                                                                                |

### Lists

* `USER_TITLE`
    - `MR` 
    - `MRS` 
    - `MS` 

`BookBookingsBookGuests` business object definition
---------------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `bookBookingsfk` link to **`BookBookings`**                  | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `bookBookingsfk.BookBookings_BookUsers_id`_            | _id_                                     |          |           |          | -                                                                                |
| _Ref. `BookBookings_BookUsers_id.usr_last_name`_             | _char(50)_                               |          |           | yes      | _Last name_                                                                      |
| _Ref. `BookBookings_BookUsers_id.usr_first_name`_            | _char(50)_                               |          |           | yes      | _First name_                                                                     |
| _Ref. `BookBookings_BookUsers_id.bookBookusersEmail`_        | _email(100)_                             |          |           |          | -                                                                                |
| _Ref. `bookBookingsfk.bookBookbookingsDate`_                 | _date_                                   |          |           |          | -                                                                                |
| _Ref. `bookBookingsfk.bookBookbookingsHour`_                 | _time_                                   |          |           |          | -                                                                                |
| _Ref. `bookBookingsfk.bookBookbookingsStartDate`_            | _datetime_                               |          |           |          | -                                                                                |
| _Ref. `bookBookingsfk.bookBookbookingsEndDate`_              | _datetime_                               |          |           |          | -                                                                                |
| _Ref. `bookBookingsfk.bookBookbookingsStatut`_               | _enum(2) using `BOOKBOOKBOOKINGSSTATUT` list_ |          |           |          | -                                                                                |
| `bookGuestsId` link to **`BookGuests`**                      | id                                       | *        | yes       |          | -                                                                                |
| _Ref. `bookGuestsId.usr_last_name`_                          | _char(50)_                               |          |           | yes      | _Last name_                                                                      |
| _Ref. `bookGuestsId.usr_first_name`_                         | _char(50)_                               |          |           | yes      | _First name_                                                                     |
| _Ref. `bookGuestsId.bookBookusersEmail`_                     | _email(100)_                             |          |           |          | -                                                                                |
| `bookBookingsGuestsBookRoomId` link to **`BookRoom`**        | id                                       |          | yes       |          | -                                                                                |
| _Ref. `bookBookingsGuestsBookRoomId.bookRoomCode`_           | _char(20)_                               |          |           |          | -                                                                                |
| _Ref. `bookBookingsGuestsBookRoomId.bookRoomLabel`_          | _char(255)_                              |          |           |          | -                                                                                |
| _Ref. `bookBookingsGuestsBookRoomId.BookRoom_BookRoomType_id`_ | _id_                                     |          |           |          | -                                                                                |
| _Ref. `BookRoom_BookRoomType_id.bookRoomtypType`_            | _text(100)_                              |          |           |          | -                                                                                |
| _Ref. `bookBookingsGuestsBookRoomId.bookRoomSuperficie`_     | _enum(10) using `BOOKROOMSUPERFICIE` list_ |          |           |          | -                                                                                |
| _Ref. `bookBookingsGuestsBookRoomId.bookRoomFloor`_          | _enum(2) using `BOOKROOMFLOOR` list_     |          |           |          | -                                                                                |
| _Ref. `bookBookingsGuestsBookRoomId.bookRoomPhoto`_          | _image_                                  |          |           |          | -                                                                                |
| _Ref. `bookBookingsGuestsBookRoomId.bookRoomPriceht`_        | _float(11, 2)_                           |          |           |          | -                                                                                |

### Lists

* `BOOKBOOKBOOKINGSSTATUT`
    - `EA` En attente
    - `TR` Traitée
    - `Cl` Clôturée
* `BOOKROOMSUPERFICIE`
    - `12` 12 m2
    - `15` 15 m2
    - `17` 17 m2
    - `22` 22m2
* `BOOKROOMFLOOR`
    - `0` RDC
    - `1` 1er
    - `2` 2ème
    - `3` 3ème
    - `4` 4ème
    - `5` 5ème
    - `6` 6ème

`BookingCreation` business process definition
---------------------------------------------

Process to create booking

### Activities

* `Begin`: 
* `CreateBooking`: 
* `End`: 
* `CreateGuests`: Create Guests
* `Identification`: Identification : Customer creation

`BookBookingFrontEnd` external object definition
------------------------------------------------




