from twilio.rest import Client

account_sid = 'AC32e1ed8dddfb567fb21546c6298b5da3'
auth_token = '99b0f775136c9e9070d00ccf5516ae07'

client = Client(account_sid, auth_token)

message = client.messages.create(
    to="+19168057009",
    from_="+12073877607",
    body="Bob is currently facing an emergency. Reply with CALL to call him now.")
print(message.sid)
