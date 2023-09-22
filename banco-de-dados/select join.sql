select 
	idendereco codigo, 
	cep, 
	e.idbairro, 
	b.nome_bairro
	--,ci.nome_cidade
from aula.endereco e 
full join aula.bairro b on b.idbairro = e.idbairro
inner join aula.bairro b on b.idbairro = e.idbairro
--right join aula.bairro b on b.idbairro = e.idbairro
--left join aula.bairro b on b.idbairro = e.idbairro
right join aula.cidade ci on ci.idcidade = e.idcidade


where 
	idendereco > 5 
	and idcidade = 2 
	or cep = '11111111'

select * from aula.endereco
select * from aula.bairro
select * from aula.cidade

insert into aula.bairro 
(nome_bairro)
values
('Fonte Santa'),
('Albuquerque')

insert into aula.cidade
(nome_cidade)
values
('Petrópolis')

insert into aula.endereco
(cep, logradouro)
values
('99999999', 'Rua Peixoto'),
('00000000', 'Rua Marechal')

select cl.nome cliente, v.numero, v.data_emissao, ve.nome vendedor, 
	e.logradouro, cl.numero_endereco, b.nome_bairro, ci.nome_cidade, e.cep,
	em.email, tel.numero_tel, pr.codigo, pr.descricao, it.valorun, it.quantidade,
	sum(it.valorun * it.quantidade) totalItem
from aula.venda v
left join aula.vendedor ve on ve.idvendedor = v.idvendedor
left join aula.cliente cl on cl.idcliente = v.idcliente
left join aula.endereco e on e.idendereco = cl.idendereco
left join aula.bairro b on b.idbairro = e.idbairro
left join aula.cidade ci on ci.idcidade = e.idcidade
left join aula.email em on em.idcliente = cl.idcliente
left join aula.telefone tel on tel.idcliente = cl.idcliente
left join aula.itens it on it.idvenda = v.idvenda
left join aula.produto pr on pr.idproduto = it.idproduto
where numero = '450'
group by cl.nome, v.numero, v.data_emissao, ve.nome, 
	e.logradouro, cl.numero_endereco, b.nome_bairro, ci.nome_cidade, e.cep,
	em.email, tel.numero_tel, pr.codigo, pr.descricao, it.valorun, it.quantidade

select * from aula.itens where idvenda = 6

select * from aula.cliente where idcliente = 3
select * from aula.endereco where idendereco = 2
select * from aula.venda
select * from aula.email
select * from aula.telefone

update aula.endereco set logradouro = 'Rua João' where idendereco = 2