create table vaga(
	id int auto_increment not null,
	fk_id_vaga int not null,
	fk_placa_veiculo char(8) not null,
	hora_entrada time,
	hora_saida time,
	primary key (id),
	foreign key (fk_id_vaga) references estacionamento(id_vaga),
	foreign key (fk_placa_veiculo) references veiculo(placa_veiculo)
);