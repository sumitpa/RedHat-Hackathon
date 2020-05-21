# Check out https://hub.docker.com/_/node to select a new base image
FROM node:10-slim
WORKDIR /app
COPY . /app

#Adding the lib dependency
RUN npm install

#Temporary to simulate stage in Boomerang - Needs to be removed for Bluemix deployment
# ENV NODE_ENV=""
# ENV DB_HOST=""
# ENV DB_PORT=""
# ENV DB_URL=""
# ENV DB_NAME=""
# ENV DB_PASSWORD=""
# ENV DB_USER=""
# ENV PORT 4544
EXPOSE 4544
CMD ["npm", "start"]
