create table estacionamento(
	id_vaga int not null,
	ocupado boolean default false,
	primary key (id_vaga)
);