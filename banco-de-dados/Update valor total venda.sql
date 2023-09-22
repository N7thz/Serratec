create table aula.vendas (
	idvenda serial primary key,
	data_emissao date not null,
	numero varchar(10) not null,
	vltotal double precision
);

create table aula.item (
	iditem serial primary key,
	idvenda int references aula.vendas(idvenda),
	idproduto int references aula.produto(idproduto),
	valorun double precision,
	quantidade double precision,
	vldesconto double precision,
	vlacrescimo double precision
);

insert into aula.vendas
(data_emissao, numero)
values
('2023-08-20', '0001')

select * from aula.vendas
select * from aula.item

insert into aula.item
(idvenda, idproduto, valorun, quantidade)
values
(1, 1, 10, 5),
(1, 2, 50, 10),
(1, 3, 5, 25)

update aula.vendas set vltotal = 
(select 
	sum((coalesce(valorun, 0) * coalesce(quantidade, 0)) - 
		(coalesce(vldesconto,0) * coalesce(quantidade, 0)) + 
		coalesce((vlacrescimo * quantidade), 0))
from aula.item where idvenda = 1)