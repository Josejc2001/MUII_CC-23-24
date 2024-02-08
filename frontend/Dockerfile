FROM node:19-alpine

# Set the working directory
WORKDIR /app

# Copy the package.json and package-lock.json
COPY package*.json ./

# Install the dependencies
RUN npm install

# Copy the rest of the application files
COPY . .

# Build the Angular application
RUN npm run build

# Expose the port where the application will run
EXPOSE 4200

# Start the application
CMD ["npm", "run", "start"]