select v.idvenda, cl.nome cliente, v.numero, v.data_emissao, ve.nome vendedor, 
	e.logradouro, cl.numero_endereco, b.nome_bairro, ci.nome_cidade, e.cep,
	em.email, tel.numero_tel, total
from aula.venda v
left join aula.vendedor ve on ve.idvendedor = v.idvendedor
left join aula.cliente cl on cl.idcliente = v.idcliente
left join aula.endereco e on e.idendereco = cl.idendereco
left join aula.bairro b on b.idbairro = e.idbairro
left join aula.cidade ci on ci.idcidade = e.idcidade
left join aula.email em on em.idcliente = cl.idcliente
left join aula.telefone tel on tel.idcliente = cl.idcliente
left join (select idvenda, sum(valorun * quantidade) total from aula.itens
			group by idvenda) it on it.idvenda = v.idvenda
where numero = '450'

left join  -> traz todos os dados da tabela1 (left) e os dados da tabela2 (right) correspondentes à tabela1
right join -> traz todos os dados da tabela2 (right) e os dados da tabela1 (left) correspondentes à tabela2 
inner join -> traz somente os dados correspondentes à tabela1 e tabela2 (intercessão)
full join  -> traz todos os dados da tabela1 e todos os dados da tabela2