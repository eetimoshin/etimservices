# Проект для практики построения микросервисной архитектуры
Этот проект предназначен для практики построения микросервисной архитектуры. В нем используются следующие технологии:

- Eureka Server: Сервер для обнаружения сервисов, который позволяет микросервисам находить друг друга и взаимодействовать без необходимости жестко прописывать адреса
- OpenFeign: HTTP клиент для упрощения взаимодействия между микросервисами. Позволяет делать HTTP-запросы к другим сервисам с помощью декларативного синтаксиса
- Spring Cloud Sleuth / Zipkin: Инструменты для распределенного трассирования, которые помогают отслеживать и анализировать запросы, проходящие через несколько микросервисов. Sleuth добавляет метки к логам, а Zipkin собирает и отображает эти данные
- API Gateway: Центральный шлюз для управления и маршрутизации API-запросов. Обеспечивает единый входной пункт для всех запросов к микросервисам.
- RabbitMQ: Мессенджер для асинхронной коммуникации между микросервисами. Позволяет микросервисам обмениваться сообщениями.

# Проект разделен на микросервисы:
- customer отвечает за регистрацию нового пользователя.
- fraud производит проверку регистрируемого пользователя (fraud-check).
- notification производит сохранение в бд приветственного сообщения.

# Адреса
- eurika-server: http://localhost:8761/
- pgadmin: http://localhost:5050/
- zipkin: http://localhost:9411/zipkin/
- rabbitMQ: http://localhost:15672/

# Запуск проекта
- Проект можно запустить в docker при помощи команды docker-compose up -d
- Проект можно запустить вручную. Для этого надо запустить в docker: postgres, pgadmin, zipkin, rabbitMQ. Руками запустить ApiGWApplication, EurekaServerApplication, а также FraudApplication, CustomerApplication и Notification ("default" active profiles)
#

![144061535-7a42e85b-59d6-4f7f-9c35-18a48b49e6de](https://github.com/eetimoshin/etimservices/assets/122122063/c5696096-9b59-4073-b0d4-27dc66ea0ecc)
