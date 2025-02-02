use BDOICOTI;

db.produto.insertMany([
	{
		idProduto: 100,
		nomeFilme: "Shazzan",
		precoAluguel: 12,
		imagem: "http://br.web.img3.acsta.net/c_215_290/pictures/19/02/21/21/08/3735597.jpg"
	},
	{
		idProduto: 101,
		nomeFilme: "Vingadores",
		precoAluguel: 20,
		imagem: "https://www.hojeemdia.com.br/polopoly_fs/1.708537.1555629319!/image/image.jpg_gen/derivatives/landscape_653/image.jpg"
	},
	{
		idProduto: 102,
		nomeFilme: "a mula",
		precoAluguel: 15,
		imagem: "https://static.cineclick.com.br/sites/adm/uploads/banco_imagens/77/1260x530_1554998019.jpg"
	}
])

db.produto.find().pretty();
db.produto.find({nomeFilme: "a mula"}).pretty();
db.produto.find({},{nomeFilme: 1}).pretty();

db.produto.find({},{nomeFilme: 1,_id:0}).pretty();

show collections;

--db.produto.drop();
--db.produto.remove();
--db.produto.remove({"idProduto" : 102});

db.produto.count();

