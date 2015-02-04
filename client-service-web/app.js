var express = require('express')
var app = express()
var path = require('path')

app.use(express.static(path.join(__dirname, 'app')));

app.get('/*', function (req, res) {
  console.log('GET req: ' + req.protocol + '://' + req.get('host') + req.originalUrl)
  res.setHeader('Content-Type', 'application/json');
  res.end(JSON.stringify(
      {"clCunitId":"1",
       "clCusNo":"105150",
       "clCustId":"549401",
       "clId":"2158931",
       "clModifier":"REPLICATION",
       "clMotime":"2014-01-03T10:02:41Z",
       "clNationality":"DK",
       "clPerMaritalStat":"Z Zonaty",
       "clPerPoliticExposed":"N",
       "clShortName":"ZIEMICKI GRZYMIS��AW"
       }
  ));
})

app.put('/*', function (req, res) {
  console.log('POST req: ' + req.protocol + '://' + req.get('host') + req.originalUrl)
  var bodyStr = '';
  req.on("data",function(chunk){
    bodyStr += chunk.toString();
  });
  req.on("end",function(){
    console.log(bodyStr);
  });
  res.status(201)
  res.end()
})

var server = app.listen(3000, function () {
  var host = server.address().address
  var port = server.address().port

  console.log('Example app listening at http://%s:%s', host, port)

})
