'use strict';

var Country = (function() {
  var countries = {
    PL: {value: 1},
    LT: {value: 2},
    LV: {value: 3},
    EE: {value: 4}
  }

  function Country() {
  }

  Country.prototype.getCodeFromCountry = function(c) {
    return countries[c].value
  }

  Country.prototype.getCountryFromCode = function(i) {
    var keys = Object.keys(countries)
    return keys[i - 1];
  }

  return Country;
})();

angular.module('clientApp', [ 'ngResource' ]);

angular.module('clientApp').directive('countryConverter', function() {
  return {
    require: 'ngModel',
    link: function(scope, element, attrs, ngModelController) {
      ngModelController.$parsers.push(function(data) {
        var c = new Country;
        console.log(data + ' ==> ' + c.getCodeFromCountry(data))
        return c.getCodeFromCountry(data);
      });

      ngModelController.$formatters.push(function(data) {
        var c = new Country;
        console.log(data + ' ==> ' + c.getCountryFromCode(data))
        return c.getCountryFromCode(data);
      });
    }
  }
});

angular.module('clientApp').controller(
  'ClientCtrl', function ($scope, ClientService) {
    $scope.client = {'clCunitId': '1', 'clCustId': '549401'}

    $scope.lookup = function (client) {
      console.log("Lookup: " + JSON.stringify(client))
      var c = new Country;
      client.clCunitId = c.getCountryFromCode(client.clCunitId)
      $scope.client = ClientService.lookup(client)
    };

    $scope.save = function (client) {
      $scope.client = ClientService.save(client)
    }
  });


angular.module('clientApp').service('ClientService',
function ClientService($resource) {
  return $resource('1.0/clients/:clCunitId/:clCustId', {}, {
    lookup: {
      method: 'GET'
    },
    save: {
      method: 'PUT'
    }
  });
});
