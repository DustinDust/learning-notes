<!-- markdownlint-disable MD013-->

# Reviewing Pull Request - Blog article

[Source](https://chelseatroy.com/2019/12/18/reviewing-pull-requests/)

## Why most pull request reviews suck

While asynchronous communication is a strength and important for distributed team, and code reviews are a better way to perform asynchronous communication, most pull request reviews suck.

According to the author, this is why:

- **There's a power imbalance in bad code reviews**: the revier records idea in a way that they get credit if it works, but the original developer undertake all the risk. For example, when the reviewers speak suggestions that don't work, it is the original developer who loses time chasing those suggestions.
- **Lack of practical engagement**: it sucks when it's obvious that the reviewer did not pull down or run the code at all. He won't understand all the context, and will not be able to provide quality feedback.
- **Setting the bar too low**: the author's mad that most professional advice for code reviews only focuses on basic civility such as no insults or add perfunctory compliments. They're not effective.

## The solution

The author suggests to move away from those cursory reviews

- **Pull the code down and test alternatives themselves**, and push a commit with a fix for the original developer to review.
- **Verbatim, copy-pastable code** that the developer can make use of.
- **Links to relevant documentation**
- **Asks questions to gain more context** before making assumptions or judgements.

## Other small stuff

The author also suggests other things to do to make your own code review participants as useful as possible.

- **Pointing out hidden gems in the code that usually overlooked**
- **Proof read your review** usually by checking if it can be supplanted by a google search or other source
- **Feed back for both what SHOULD change and what SHOULDN'T change**
