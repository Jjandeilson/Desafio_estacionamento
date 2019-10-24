create table veiculo(
	placa_veiculo char(8) not null unique,
	cliente varchar(60) not null,
	cidade varchar(60) not null,
	uf char(2),
	primary key (placa_veiculo)
);