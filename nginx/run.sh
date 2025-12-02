echo "shutting down $(docker rm -f nginx)"
docker run --name nginx -p 80:80 -v ./nginx.conf:/etc/nginx/nginx.conf:ro -v ./default.conf:/etc/nginx/conf.d/default.conf -d nginx
