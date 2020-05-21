'use strict';

module.exports = function (Patient) {

  Patient.observe('before save', function (ctx, next) {
    if (ctx.instance) {
      var data = ctx.instance;
      //data.id = "P" + "-" + new Date().getMilliseconds();
      data.bmi = Number.isNaN(data.weight / (data.height * data.height)) == true ? 0 : data.weight / (data.height * data.height);
      console.log(data);
      ctx.instance = data;
      if (validateDate(data))
        next()
      else
        next(new Error('Wrong Data'))
    } else {
      var data = ctx.data;
      data.bmi = Number.isNaN(data.weight / (data.height * data.height)) == true ? 0 : data.weight / (data.height * data.height);
      console.log(data);
      ctx.data = data;
      if (validateDate(data))
        next()
      else
        next(new Error('Wrong Data'))
    }

  });

  function validateDate(data) {
    var flag = false
    if (data.name.firstName.length > 20)
      flag = false;
    else
      flag = true;

    return flag;
  }

};
