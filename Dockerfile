FROM python:3.8.5-alpine

# Copy src code from Host to Container
COPY ./src/main /usr/app/src/main

# Tells the root location for project
ENV PYTHONPATH="/usr/app"

# Run the application
ENTRYPOINT ["python"]
CMD ["/usr/app/src/main/main.py"]
