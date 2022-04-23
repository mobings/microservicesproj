# microservicesproj

Movie-service needs authrization 

---To generate token postman or curl as below

Step 1:  curl --user movie-service-client:secretwinepassword POST  -d "scope=webclient&grant_type=password&username=moby.dilson&password=pa55word" http://localhost:1020/oauth/token


-- To call movie-service API

Step 2: curl  localhost:7777/movies/cinemas/1 -H "Accept: application/json" -H "Authorization: Bearer {your accesstoken generated in step 1}"