#Aluno: Renan Kodama Rodrigues RA:1602098
#Teoria dos Grafos UTFPR-CM

#Funcionamento:
#	Após executar o programa, é pedido pelo console que o usuário entre com o nome de qual algoritmo de busca usar
#	podendo ser BL(Busca em Largura) ou BP(Busca em Profundidade);
#	As funções que implementam os algoritmos de buscas mencionados anteriormente se encontram nas classes BuscaLargura
#	e BuscaProfundidade; 
#	A classe que inicia as funcionalidades é a "TiposBuscas" nela se encontra dois modelos prontos para a entrada:
#	Input01: A->B
#                B->C
#                C->B
#                C->D
#                D->A	
#	
#	Input02:A->B
#              	A->D
#               B->E
#               E->D
#               D->B
#               F->E	
#               F->G
#               G->G
#
#	Classes:
#		Aresta- 		classe composta por vertices destino e peso, podendo ser vertices do tipo BL(BuscaLargura) ou BP(BuscaProfundidade);
#         	BuscaLargura-		classe composta pelas funções correspondete à busca em largura;
#		BuscaProfundidade-	classe composta pelas funções correspondete à busca em profundidade;
#		Grafo-			classe composta pelo HashMap usado como lista de adjacencias;
#		MatrizAdj-		classe composta pela matriz de adjacencia e suas funcões;
#		Principal-		classe que instancia e inicia a classe TiposBuscas;
#		TiposBuscas-		classe que inicia os demais algoritmos escolhidos;
#		Transicoes-		classe que representa o grafo de entrada como uma lista contendo uma origem, destino e peso;
#		Vertice_BL-		classe que representa os vertices do grafo, contendo seus atributos especificos da Busca em Largura;
#		Vertice_BP-		classe que reoresenta os vertices do grafo, contendo seus atributos especificos da Busca em Profundidade;
