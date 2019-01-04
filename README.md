# WeatherForecastApp



Utiliza a Api openweathermap 5 day/3 hour forecast 
Atualiza a informação relativa a cada cidade atraves da api de 3 em 3 minutos 
e guarda na base de dados. Se nao for necessário atualizar então acede diretamente 
à base de dados.


explicação geral da arquitetura seguida (identificando as entidades, o repositório, os módulos/bibliotecas para consumo da API externa,...)
A arquitetura teve como base o exemplo providenciado no enunciado.
Existe apenas uma Entidade que guarda objectos ou listas do Json. Para tal sao utilizados
Converters para cada tipo de objecto/classe de forma a guardar na base de dados.
A informação recolhida do Json para a base de dados é apenas a essencial(nome da Cidade,
temperatura minima/maxima, descrição ...) que está exposta na UI.


explicação sucinta da funcionalidade implementada.
A aplicação permite pesquisar por Cidades e obter a informação meteorologia de cada uma delas 
no espaço de 5 dias.


identificar limitações (o que se queria ter colocado a funcionar, mas não se conseguiu ou fez-se de outra forma, menos adequada)
O ideal era ter acesso a Api openweathermap 16 day/daily forecast(paga) pois os dados da temperatura
são relativos ao dia. O JSON é mais compacto e nao sobrecarga a base de dados. Assim na base de dados 
encontra-se todos os registos de 3 em 3 horas de cada dia e apenas um desses é mostrado na UI 
não refletindo propriamente os dados relativos ao dia inteiro.



