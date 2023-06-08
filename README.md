Projeto a ser desenvolvido :
Sistema para gerenciamento de biblioteca com as informações armazenadas em um banco de dados. 
Não será necessário construir a interface gráfica do sistema. Os principais requisitos do sistema são:

•	Gerenciamento de obras da biblioteca:
o	Acervo físico: livros e revistas
o	Acervo digital: postagens
•	Gerenciamento de usuários da biblioteca:
o	Professores 
o	Estudantes

•	Gerenciamento de empréstimos de obras para usuários:
o	Professores podem pegar obras emprestadas por 10 dias
o	Estudantes podem pegar obras emprestadas por 7 dias
o	A obra (entenda aqui a obra como um volume, com um identificador único por volume) pode estar emprestada para um único usuário. Isto mesmo para obras digitais.
o	Se na devolução for detectado atraso, ambos pagam multa de R$ 2,00 por obra e por dia de atraso.
•	Serviços que devem ser expostos (API a ser exposta):
o	Pesquisar um livro específico por título e/ou nome do autor.
o	Listar todos os livros por ordem alfabética de título e/ou nome do autor.
o	Pesquisar um usuário específico por nome e/ou RG.
o	Listar todos os usuários por ordem alfabética de nome e/ou ordem de ID.
o	Registrar que um usuário emprestou uma obra.
o	Registrar que um usuário devolveu uma obra.
o	Para um usuário específico, listar as obras que ele pegou emprestado.
