# Advocu Personal API

This document describes how to authenticate to the Advocu API, and how to access API endpoints

## Authentication and rate limits

Generate your API token and review rate limits before getting started

### API Token

Generate you token... 

### Authentication to API endpoints

Include all required HTTP headers in your requests

-   **Base url:** `https://api.advocu.com/personal-api/v1/dockercaptains`
-   **Content-Type:** `application/json`
-   **Authorization:** `Bearer {access-token}`

### Rate limits

Access to Personal API is limited to 30 requests per minute for IP address. Once an individual IP address range exceeds a rule threshold, further requests to the origin server are blocked with an HTTP 429 response status code.

## Activity Drafts

Here is how you can send the activity draft to the platform

### POST /activity-drafts/feedbackSession

| Name | Type | Description | Accepted if Restrictions |
| :--- | :--- | :--- | :--- |
| activityDate | string | Date of the feedback session | pattern YYYY-MM-DD |
| dockerRepresentative | string | Docker representative | max length 100, min length 3 |
| modeOfCommunication | string | Mode of communication | enum [4 values] |
| metrics.timeSpent | integer | Approximate time spent (in minutes) | minimum 1 |
| title | string | Docker feature discussed | max length 200, min length 3 |
| description | string | Key feedback points discussed | max length 2000 |
| private | boolean | Do you want to make this activity private? | - |

### POST /activity-drafts/resources

| Name | Type | Description | Accepted if Restrictions |
| :--- | :--- | :--- | :--- |
| title | string | Name of your project | max length 200, min length 3 |
| description | string | What is this resource about? | max length 2000 |
| tags | array | Tags | enum [0 values], min items 0 |
| activityUrl | string | Link to the resource | max length 500, pattern ^https?:\/\/(www\.)?.*$ |
| activityDate | string | Date published | pattern YYYY-MM-DD |
| metrics.views | integer | How many people has seen your content? | minimum 1 |
| contentType | string | Content type | enum [11 values] |
| additionalInfo | string | Additional information | max length 2000 |
| private | boolean | Do you want to make this activity private? | - |

### POST /activity-drafts/public-speaking

| Name | Type | Description | Accepted if Restrictions |
| :--- | :--- | :--- | :--- |
| title | string | What was the title of your talk? | max length 200, min length 3 |
| description | string | What was it about? | max length 2000 |
| tags | array | Tags | enum [0 values], min items 0 |
| activityUrl | string | Share any relevant link | max length 500, pattern ^https?:\/\/(www\.)?.*$ |
| activityDate | string | Date of your talk | pattern YYYY-MM-DD |
| format | string | What was your talk’s format? | enum [4 values] |
| duration | integer | How long did your talk take (in minutes)? | minimum 1 |
| additionalInfo | string | Additional information | max length 2000 |
| metrics.attendees | integer | How many people attended your talk? | minimum 1 |
| private | boolean | Do you want to make this activity private? | - |

### POST /activity-drafts/event

| Name | Type | Description | Accepted if Restrictions |
| :--- | :--- | :--- | :--- |
| title | string | What is your event title? | max length 200, min length 3 |
| description | string | Description | max length 2000 |
| tags | array | Tags | enum [0 values], min items 0 |
| activityUrl | string | Event URL | max length 500, pattern ^https?:\/\/(www\.)?.*$ |
| dates.start | string | Event start date | pattern YYYY-MM-DD |
| dates.end | string | Event end date | pattern YYYY-MM-DD |
| type | string | What kind of event did you organize? | enum [10 values] |
| format | string | What was your event’s format? | enum [3 values] |
| duration | string | Event duration | enum [5 values] |
| additionalInfo | string | Additional information | max length 2000 |
| metrics.attendees | integer | How many people attended the event? | minimum 1 |
| private | boolean | Do you want to make this activity private? | - |

### POST /activity-drafts/amplification

| Name | Type | Description | Accepted if Restrictions |
| :--- | :--- | :--- | :--- |
| activityDate | string | Date of the amplification | pattern YYYY-MM-DD |
| metrics.views | integer | Approximate reach or views | minimum 1 |
| title | string | Title | max length 200, min length 3 |
| description | string | Description | max length 2000 |
| type | array | Type | enum [3 values], max items 3, min items 1 |
| channel | array | Channel | enum [4 values], max items 4, min items 1 |
| url | string | URL Link | max length 100 |
| private | boolean | Do you want to make this activity private? | - |
