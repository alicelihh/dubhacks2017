## LanguageBot

**Scope:**
Our project took its inspiration from the recent, numerous, sexual allegations in the news and also on campus. From this, we wanted to create a tool that would help educate and spread resources about prevention of and protection against sexual assault. To accomplish this we narrowed our focus to cyberbullying through direct messaging services.


**Implementation:**
We developed using the NetBeans IDE and worked with Microsoft's Text Analytics API which can be found [here](https://docs.microsoft.com/en-us/azure/cognitive-services/Text-Analytics/QuickStarts/Java#prerequisites). We leveraged the Analyze Sentiment and Extract Key Phrases queries to process messenges as they were sent. 

Our analysis is two fold. First, we looked at the sentimentScore and, based on a threshold that was determined by several test cases, we used the negativity metric for further evaluation. The second review involves consideration of the key words and phrases in the messages and checks them against our own flagged terms. If the message contains any of these terms, then it's flagged. The sender receives a warning, letting them know their message was flagged and prompts them to review their online behavior. The recipient receives a message informing them the content was detected as inappropriate and provides resources for safety and support against cyberbullying. 

Note, if you download the source code into NetBeans, make sure the Libraries under Project Properties contains `gson-2.8.1.jar`.


**Impact:**
Online messaging services are ubiquitous and reach a wide range of people. These platforms are creating unmonitored spaces that facilitate cyberbullying, as shown by nearly 43% of kids have been bullied online [DoSomething.org](https://www.dosomething.org/us/facts/11-facts-about-cyber-bullying). 9 out of 10 victims also won't report the incidents to an adult [DoSomething.org](https://www.dosomething.org/us/facts/11-facts-about-cyber-bullying). This leaves a considerable number of people without the support they need, which can have lasting consequences. This tool will provide users with real-time support and connect them with immediate access to resources. This tool would be avaliable to all people using online messaging services, regardless of who they are. This empowers victims to look out for themselves in the face of unwanted advances, also helping them mitigate long term affects of cyberbullying. 


**Challenges:**
We recognize a privacy issue can arise when accessing people's personal messages. However, we emphasize that the computer program auto detects the key phrases, keeping the privacy of users since no individual is reviewing the exchanges. We also emphasize the importance of education. 

Our application is education purpose based, because we realize how difficult it is to wipe out such behaviour, since it is so deeply rooted. The most effective way is the step by step approach, which makes people understand why it is not okay to use inappropriate languages and how such behaviour could influence other people. Potentially, the mental awareness of cautiously using language will evolve to physical behaviours.

We want to improve the condition of people being sexually harassed, by raising awareness on the use of language. We want to educate people on the appropriate languages that could be used when talking to someone else. 

**Future Extensions:**

* Integrate with multiple media platforms
* Incorporate machine learning for accurate analysis
* Implement detection for images and speech
* Analyze tone of the entire message history in addition to each specific message


_Built for DubHacks2017_
