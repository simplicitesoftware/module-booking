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



`BookBookings` business object definition
-----------------------------------------

Bookings of a customer

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `bookBookingsBookUsersId` link to **`BookUsers`**            | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `bookBookingsBookUsersId.bookUserTitle`_               | _enum(5) using `USER_TITLE` list_        |          |           |          | _Title_                                                                          |
| _Ref. `bookBookingsBookUsersId.BookUserLastname`_            | _char(50)_                               |          |           |          | _Last name_                                                                      |
| _Ref. `bookBookingsBookUsersId.bookUserFirstname`_           | _char(50)_                               |          |           |          | _First name_                                                                     |
| _Ref. `bookBookingsBookUsersId.bookUserEmail`_               | _email(100)_                             |          |           |          | -                                                                                |
| `bookBookingsDate`                                           | date                                     | yes*     |           |          | -                                                                                |
| `bookBookingsHour`                                           | time                                     | yes*     |           |          | -                                                                                |
| `bookBookingsStartDate`                                      | datetime                                 | yes      | yes       |          | -                                                                                |
| `bookBookingsEndDate`                                        | datetime                                 | yes      | yes       |          | -                                                                                |
| `bookBookingsPaymentDate`                                    | date                                     |          |           |          | -                                                                                |
| `bookBookingsAmountDate`                                     | date                                     |          |           |          | -                                                                                |
| `bookBookingsPaymentDone`                                    | boolean                                  |          | yes       |          | -                                                                                |
| `bookBookingsComments`                                       | html(2000)                               |          | yes       |          | -                                                                                |
| `bookBookingsStatus`                                         | enum(2) using `BOOKBOOKINGSSTATUS` list  |          | yes       |          | -                                                                                |
| `bookBookingsRoomNumber`                                     | enum(100) using `BOOKBOOKINGSROOMNUMBER` list | yes      | yes       |          | -                                                                                |
| `bookBookingsGuestNumber`                                    | enum(2) using `BOOKBOOKINGSROOMNUMBER` list |          | yes       |          | -                                                                                |

### Lists

* `USER_TITLE`
    - `MR` 
    - `MRS` 
    - `MS` 
* `BOOKBOOKINGSSTATUS`
    - `EA` En attente
    - `TR` Traitée
    - `Cl` Clôturée
* `BOOKBOOKINGSROOMNUMBER`
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

`BookBookingsBookGuests` business object definition
---------------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `bookBookingsId` link to **`BookBookings`**                  | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `bookBookingsId.bookBookingsBookUsersId`_              | _id_                                     |          |           |          | -                                                                                |
| _Ref. `bookBookingsBookUsersId.BookUserLastname`_            | _char(50)_                               |          |           |          | _Last name_                                                                      |
| _Ref. `bookBookingsBookUsersId.bookUserFirstname`_           | _char(50)_                               |          |           |          | _First name_                                                                     |
| _Ref. `bookBookingsBookUsersId.bookUserEmail`_               | _email(100)_                             |          |           |          | -                                                                                |
| _Ref. `bookBookingsId.bookBookingsDate`_                     | _date_                                   |          |           |          | -                                                                                |
| _Ref. `bookBookingsId.bookBookingsHour`_                     | _time_                                   |          |           |          | -                                                                                |
| _Ref. `bookBookingsId.bookBookingsStartDate`_                | _datetime_                               |          |           |          | -                                                                                |
| _Ref. `bookBookingsId.bookBookingsEndDate`_                  | _datetime_                               |          |           |          | -                                                                                |
| _Ref. `bookBookingsId.bookBookingsStatus`_                   | _enum(2) using `BOOKBOOKINGSSTATUS` list_ |          |           |          | -                                                                                |
| `bookBookingsGuestsBookRoomId` link to **`BookRoom`**        | id                                       |          | yes       |          | -                                                                                |
| _Ref. `bookBookingsGuestsBookRoomId.bookRoomCode`_           | _char(20)_                               |          |           |          | -                                                                                |
| _Ref. `bookBookingsGuestsBookRoomId.bookRoomLabel`_          | _char(255)_                              |          |           |          | -                                                                                |
| _Ref. `bookBookingsGuestsBookRoomId.bookRoomBookRoomTypeId`_ | _id_                                     |          |           |          | -                                                                                |
| _Ref. `bookRoomBookRoomTypeId.bookRoomtypCode`_              | _char(20)_                               |          |           |          | -                                                                                |
| _Ref. `bookRoomBookRoomTypeId.bookRoomtypType`_              | _char(255)_                              |          |           |          | -                                                                                |
| _Ref. `bookBookingsGuestsBookRoomId.bookRoomSuperficie`_     | _enum(10) using `BOOKROOMSUPERFICIE` list_ |          |           |          | -                                                                                |
| _Ref. `bookBookingsGuestsBookRoomId.bookRoomFloor`_          | _enum(2) using `BOOKROOMFLOOR` list_     |          |           |          | -                                                                                |
| _Ref. `bookBookingsGuestsBookRoomId.bookRoomPhoto`_          | _image_                                  |          |           |          | -                                                                                |
| _Ref. `bookBookingsGuestsBookRoomId.bookRoomPriceht`_        | _float(11, 2)_                           |          |           |          | -                                                                                |
| `bookGuestsId` link to **`BookGuests`**                      | id                                       | *        | yes       |          | -                                                                                |
| _Ref. `bookGuestsId.BookUserLastname`_                       | _char(50)_                               |          |           |          | _Last name_                                                                      |
| _Ref. `bookGuestsId.bookUserFirstname`_                      | _char(50)_                               |          |           |          | _First name_                                                                     |
| _Ref. `bookGuestsId.bookUserEmail`_                          | _email(100)_                             |          |           |          | -                                                                                |

### Lists

* `BOOKBOOKINGSSTATUS`
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

`BookBookingsHistoric` business object definition
-------------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `row_ref_id` link to **`BookBookings`**                      | id                                       | yes*     |           |          | Record row ID                                                                    |
| `row_idx`                                                    | int(11)                                  | yes*     | yes       |          | History record index                                                             |
| `created_by_hist`                                            | char(100)                                | yes*     |           |          | Created by                                                                       |
| `created_dt_hist`                                            | datetime                                 | yes*     |           |          | Created date                                                                     |
| `bookBookingsBookUsersId` link to **`BookUsers`**            | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `bookBookingsBookUsersId.bookUserTitle`_               | _enum(5) using `USER_TITLE` list_        |          |           |          | _Title_                                                                          |
| _Ref. `bookBookingsBookUsersId.BookUserLastname`_            | _char(50)_                               |          |           |          | _Last name_                                                                      |
| _Ref. `bookBookingsBookUsersId.bookUserFirstname`_           | _char(50)_                               |          |           |          | _First name_                                                                     |
| _Ref. `bookBookingsBookUsersId.bookUserEmail`_               | _email(100)_                             |          |           |          | -                                                                                |
| `bookBookingsDate`                                           | date                                     | yes*     |           |          | -                                                                                |
| `bookBookingsHour`                                           | time                                     | yes*     |           |          | -                                                                                |
| `bookBookingsStartDate`                                      | datetime                                 | yes      | yes       |          | -                                                                                |
| `bookBookingsEndDate`                                        | datetime                                 | yes      | yes       |          | -                                                                                |
| `bookBookingsPaymentDate`                                    | date                                     |          |           |          | -                                                                                |
| `bookBookingsAmountDate`                                     | date                                     |          |           |          | -                                                                                |
| `bookBookingsPaymentDone`                                    | boolean                                  |          | yes       |          | -                                                                                |
| `bookBookingsComments`                                       | html(2000)                               |          | yes       |          | -                                                                                |
| `bookBookingsStatus`                                         | enum(2) using `BOOKBOOKINGSSTATUS` list  |          | yes       |          | -                                                                                |
| `bookBookingsRoomNumber`                                     | enum(100) using `BOOKBOOKINGSROOMNUMBER` list | yes      | yes       |          | -                                                                                |
| `bookBookingsGuestNumber`                                    | enum(2) using `BOOKBOOKINGSROOMNUMBER` list |          | yes       |          | -                                                                                |

### Lists

* `USER_TITLE`
    - `MR` 
    - `MRS` 
    - `MS` 
* `BOOKBOOKINGSSTATUS`
    - `EA` En attente
    - `TR` Traitée
    - `Cl` Clôturée
* `BOOKBOOKINGSROOMNUMBER`
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

`BookGuests` business object definition
---------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `bookUserType`                                               | enum(3) using `BOOKBOOKUSERSTYPE` list   | yes      | yes       |          | -                                                                                |

### Lists

* `BOOKBOOKUSERSTYPE`
    - `CUS` Client
    - `ACC` Accompagnateur

`BookPayments` business object definition
-----------------------------------------

Bookings payments

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `bookPaymentsBookBookingsId` link to **`BookBookings`**      | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `bookPaymentsBookBookingsId.bookBookingsBookUsersId`_  | _id_                                     |          |           |          | -                                                                                |
| _Ref. `bookPaymentsBookBookingsId.bookBookingsDate`_         | _date_                                   |          |           |          | -                                                                                |
| _Ref. `bookPaymentsBookBookingsId.bookBookingsHour`_         | _time_                                   |          |           |          | -                                                                                |
| _Ref. `bookBookingsBookUsersId.bookUserTitle`_               | _enum(5) using `USER_TITLE` list_        |          |           |          | _Title_                                                                          |
| _Ref. `bookBookingsBookUsersId.BookUserLastname`_            | _char(50)_                               |          |           |          | _Last name_                                                                      |
| _Ref. `bookBookingsBookUsersId.bookUserFirstname`_           | _char(50)_                               |          |           |          | _First name_                                                                     |
| _Ref. `bookBookingsBookUsersId.bookUserEmail`_               | _email(100)_                             |          |           |          | -                                                                                |
| _Ref. `bookPaymentsBookBookingsId.bookBookingsStartDate`_    | _datetime_                               |          |           |          | -                                                                                |
| _Ref. `bookPaymentsBookBookingsId.bookBookingsEndDate`_      | _datetime_                               |          |           |          | -                                                                                |
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

`BookRoomEquipment` business object definition
----------------------------------------------

Room Equipements

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `bookEquLibell`                                              | char(255)                                | yes      | yes       |          | -                                                                                |
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
| `bookRoomtypType`                                            | char(255)                                | yes      | yes       |          | -                                                                                |

`BookRoom` business object definition
-------------------------------------

Booking rooms

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `bookRoomCode`                                               | char(20)                                 | yes*     | yes       |          | -                                                                                |
| `bookRoomLabel`                                              | char(255)                                | yes      | yes       |          | -                                                                                |
| `bookRoomBookRoomTypeId` link to **`BookRoomType`**          | id                                       |          | yes       |          | -                                                                                |
| _Ref. `bookRoomBookRoomTypeId.bookRoomtypCode`_              | _char(20)_                               |          |           |          | -                                                                                |
| _Ref. `bookRoomBookRoomTypeId.bookRoomtypType`_              | _char(255)_                              |          |           |          | -                                                                                |
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

`BookEquRoom` business object definition
----------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `bookEquroomEquId` link to **`BookRoomEquipment`**           | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `bookEquroomEquId.bookEquCode`_                        | _char(20)_                               |          |           |          | -                                                                                |
| _Ref. `bookEquroomEquId.bookEquLibell`_                      | _char(255)_                              |          |           |          | -                                                                                |
| `bookEquroomRoomId` link to **`BookRoom`**                   | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `bookEquroomRoomId.bookRoomCode`_                      | _char(20)_                               |          |           |          | -                                                                                |
| _Ref. `bookEquroomRoomId.bookRoomLabel`_                     | _char(255)_                              |          |           |          | -                                                                                |

`BookRoomBookRoomService` business object definition
----------------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `bookroomservBookRoomId` link to **`BookRoom`**              | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `bookroomservBookRoomId.bookRoomCode`_                 | _char(20)_                               |          |           |          | -                                                                                |
| _Ref. `bookroomservBookRoomId.bookRoomLabel`_                | _char(255)_                              |          |           |          | -                                                                                |
| `bookroomservBookServiceId` link to **`BookRoomService`**    | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `bookroomservBookServiceId.bookRservCode`_             | _char(20)_                               |          |           |          | -                                                                                |
| _Ref. `bookroomservBookServiceId.bookRservLibell`_           | _char(255)_                              |          |           |          | -                                                                                |

`BookUsers` business object definition
--------------------------------------

Customers

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `bookUserTitle`                                              | enum(5) using `USER_TITLE` list          |          | yes       |          | Title                                                                            |
| `BookUserLastname`                                           | char(50)                                 | yes      | yes       |          | Last name                                                                        |
| `bookUserFirstname`                                          | char(50)                                 | yes      | yes       |          | First name                                                                       |
| `bookUserWorknum`                                            | phone(20)                                |          | yes       |          | Work phone number                                                                |
| `bookUserHomenum`                                            | phone(20)                                |          | yes       |          | -                                                                                |
| `bookUserCellnum`                                            | phone(20)                                |          | yes       |          | Mobile/cellular phone number                                                     |
| `bookUserAddress1`                                           | char(100)                                | yes      | yes       |          | Address line 1                                                                   |
| `bookUserAddress2`                                           | char(100)                                |          | yes       |          | Address line 2                                                                   |
| `bookUserZipcode`                                            | char(10)                                 |          | yes       |          | Postal/ZIP code                                                                  |
| `bookUserCity`                                               | char(50)                                 | yes      | yes       |          | City                                                                             |
| `bookUserState`                                              | char(50)                                 |          | yes       |          | State                                                                            |
| `bookUserCountry`                                            | enum(20) using `COUNTRY` list            | yes      | yes       |          | Country                                                                          |
| `bookUserEmail`                                              | email(100)                               | yes*     | yes       |          | -                                                                                |
| `bookUserType`                                               | enum(3) using `BOOKBOOKUSERSTYPE` list   | yes      | yes       |          | -                                                                                |
| `bookUserGeoCoord`                                           | geocoords                                |          | yes       |          | -                                                                                |

### Lists

* `USER_TITLE`
    - `MR` 
    - `MRS` 
    - `MS` 
* `COUNTRY`
    - `FR` France
    - `UK` United Kingdom
    - `ES` Spain
    - `DE` Germany
    - `BE` Belgium
    - `CH` Switzerland
    - `IE` Ireland
    - `IT` Italy
    - `PT` Portugal
    - `NL` Netherlands
    - `CZ` Czech Republic
    - `AT` Austria
    - `CA` Canada
    - `US` United States of America
    - `AU` Australia
* `BOOKBOOKUSERSTYPE`
    - `CUS` Client
    - `ACC` Accompagnateur

`BookingCreation` business process definition
---------------------------------------------

Process to create booking

### Activities

* `Begin`: 
* `CreateBooking`: 
* `End`: 
* `CreateGuests`: Create Guests
* `Identification`: Identification : Customer creation

`BookBookingAgenda` external object definition
----------------------------------------------




`BookBookingFrontEnd` external object definition
------------------------------------------------




