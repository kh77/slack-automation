## Send message using slack api

- You need to make channel in your slack workspace chat 
- Go to api.slack.com
- Create 'App'
- Enable 'Incoming Webhooks'
- Add 'Webhook to Workspace'
- Select your channel which you created
- Allow it
- Go to 'OAuth & Permissions'
- Add 'Scopes' 
    - chat:write
    - channels:read
    
- 'Reinstall your workspace' once you allow above changes through notification if pop-up

- Go to 'Incoming Webhooks' and copy 'Webhook url' and use in the project