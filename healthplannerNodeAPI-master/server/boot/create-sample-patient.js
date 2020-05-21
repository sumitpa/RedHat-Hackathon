// Copyright IBM Corp. 2016,2019. All Rights Reserved.
// Node module: loopback-workspace
// This file is licensed under the MIT License.
// License text available at https://opensource.org/licenses/MIT

'use strict';

module.exports = async function (app) {
  await app.dataSources.mongodbDS.automigrate('Patient');
  const patient = await app.models.Patient.create([
  {
    name: {
      firstName: 'Arnab',
      lastName: 'Ray'
    },
    address: {
      line1: '31/1 Makhla Kashibati',
      line2: '',
      city: 'Uttarpara',
      state: 'West Bengal',
      zip: '712245'
    },
    gender: 'Male',
    dateOfBirth: '1981-03-29',
    mailId: 'arnaray6@in.ibm.com',
    phone: '9433234567',
    maritalStatus: 'Married',
    medHistory: ['Allergies', 'Anxiety'],
    height: '30',
    weight: '55',
    bmi: '0.06111111111111111',
    diet: 'Non-Veg',
    activity: 'Moderate',
    tobacoUse: 'Weekly',
    alchoholUse: 'Weekly',
    caffineUse: 'Daily',
    allergies: 'Yes',
    allergicFrom: ['Pollen', 'Animals']
  }, 
  ]);

  console.log('Models created: \n', patient);
};
