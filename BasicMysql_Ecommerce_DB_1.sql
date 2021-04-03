create table Users(
	idUser varchar(40) primary key not null,
	fullname varchar(40) not null,
	birthdate date ,
	inscriptionDate date,
	username varchar(40) not null,
	email varchar(40) not null,
	password varchar(40) not null,
	salt varchar(40) not null,
	postalCode varchar(15),
	direction varchar(120),
	referenceDirection varchar(120),
	coordPrimary varchar(120),
	coordSecondary varchar(120)
);
/* service create user
	create user
		create wishlist
		cretate bucket
	-> we need a procedure
*/
insert into Users(idUser,fullname,username,email,password,salt,direction,referenceDirection)
value('user-1','señor cara de papa','carepapa1','carepapa@gmail.com','caradepapa123','132','calle 77, lote 45, los paperos','casa roja de carton');
select * from Users;

CREATE PROCEDURE procedure_after_create_user (idUser varchar(40), idWishlist varchar(40) , idBucket varchar(40))
BEGIN
	insert into Wishlists(idWishlist,idUser) 
	values(idWishlist,idUser );
	insert into Buckets(idBucket,idUser) 
	values(idBucket,idUser );
END
call procedure_after_create_user ('user-1', 'wishlist-1','bucket-1');

create table Products(
	idProduct varchar(40) primary key not null,
	nameProduct varchar(40) not null,
	currentPrice decimal(5,2)  not null,
	state varchar(20) not null,
	brand varchar(40),
	category1 varchar(20),
	category2 varchar(20),
	category3 varchar(20),
	category4 varchar(20),
	urlImage1 varchar(120),
	urlImage2 varchar(120),
	urlImage3 varchar(120),
	urlImage4 varchar(120),
	`description` varchar(220),
	offertPercent decimal(5,2),
	typeProduct varchar(20),
	espec varchar(500)
);
insert into Products(idProduct,nameProduct,brand,currentPrice,state,category1,category2,urlImage1,`description`,offertPercent,typeProduct) 
value('product-1','polo','jaimito',15.5,'in sotck','clothes','tshirt','','este es un polo 100% algodon',5,'tshirt');
select * from Products;
/* service create product
	create product
		create rating
	-> we need a procedure
*/

create table Cupons(
	idCupon varchar(40) primary key not null,
	code varchar(40) not null,
	state varchar(20) not null,
	idUserUsed varchar(40) not null,
	foreign key (idUserUsed) references Users(idUser)
);
/*
	expiration date
	init date
*/

create table Orders(
	idOrder varchar(40) primary key not null,
	idUser varchar(40) not null,
	stateOrder varchar(20) not null,
	dateOrder date,
	foreign key (idUser) references Users(idUser)
);

create table OrderItem(
	idItem varchar(40) primary key not null,
	idOrder varchar(40) not null,
	idProduct varchar(40) not null,
	quantity int not null,
	foreign key (idProduct) references Products(idProduct),
	foreign key (idOrder) references Orders(idOrder)
);

create table Wishlists(
	idWishlist varchar(40) primary key not null,
	idUser varchar(40) not null,
	foreign key (idUser) references Users(idUser)
);



create table WishlistItem(
	idItem varchar(40) primary key not null,
	idWishlist varchar(40) not null,
	idProduct varchar(40) not null,
	foreign key (idWishlist) references Wishlists(idWishlist),
	foreign key (idProduct) references Products(idProduct)
);

create table Buckets(
	idBucket varchar(40) primary key not null,
	idUser varchar(40) not null,
	foreign key (idUser) references Users(idUser)
);

create table BucketItem(
	idItem varchar(40) primary key not null,
	idBucket varchar(40) not null,
	idProduct varchar(40) not null,
	foreign key (idBucket) references Buckets(idBucket),
	foreign key (idProduct) references Products(idProduct)
);


/* additional */
create table ratingProduct(
	idRating varchar(40) primary key not null,
	idProduct varchar(40) not null,
	star_1 int not null,
	star_2 int not null,
	star_3 int not null,
	star_4 int not null,
	star_5 int not null,
	foreign key (idProduct) references Products(idProduct)
)


/*api calls*/

/*product API*/
	/*get best products*/
	select * from users u inner join buckets b ,wishlists w where u.idUser = b.idUser AND u.idUSer = 'user-1';
	/*get product*/
	select * from users u inner join buckets b ,wishlists w where u.idUser = b.idUser AND u.idUSer = 'user-1';

	/*delete product*/

	/*update product*/