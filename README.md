# WeatherForecastApp



Utiliza a Api openweathermap 5 day/3 hour forecast 
Atualiza a informa��o relativa a cada cidade atraves da api de 3 em 3 minutos 
e guarda na base de dados. Se nao for necess�rio atualizar ent�o acede diretamente 
� base de dados.


explica��o geral da arquitetura seguida (identificando as entidades, o reposit�rio, os m�dulos/bibliotecas para consumo da API externa,...)
A arquitetura teve como base o exemplo providenciado no enunciado.
Existe apenas uma Entidade que guarda objectos ou listas do Json. Para tal sao utilizados
Converters para cada tipo de objecto/classe de forma a guardar na base de dados.
A informa��o recolhida do Json para a base de dados � apenas a essencial(nome da Cidade,
temperatura minima/maxima, descri��o ...) que est� exposta na UI.


explica��o sucinta da funcionalidade implementada.
A aplica��o permite pesquisar por Cidades e obter a informa��o meteorologia de cada uma delas 
no espa�o de 5 dias.


identificar limita��es (o que se queria ter colocado a funcionar, mas n�o se conseguiu ou fez-se de outra forma, menos adequada)
O ideal era ter acesso a Api openweathermap 16 day/daily forecast(paga) pois os dados da temperatura
s�o relativos ao dia. O JSON � mais compacto e nao sobrecarga a base de dados. Assim na base de dados 
encontra-se todos os registos de 3 em 3 horas de cada dia e apenas um desses � mostrado na UI 
n�o refletindo propriamente os dados relativos ao dia inteiro.



