<!-- markdownlint-disable MD013-->

# Implementing a strong code review culture

[Source](https://www.youtube.com/watch?v=PJjmw9TRB7s)

## Introduction

The early part of the video is a bit hard to follow, but overall he was talking about the (reevaluated) purpose of a code review

While catching bugs is important, it is not the main goal of a code review; the real benefits of a code review (drawn from a Microsoft study) are:

- Knowledge transfer.
- Increased team awareness.
- Finding alternatives solutions.

Next, definition of a code review:

> Discipline of discussing your code with your peers to improve technical communication.

## Rules of Engagement

(To start getting better at code review)

### As the author

> Content is king, then **context** is GOD

- Author should provide extensive context (the "why") rather than just the code (the "what").
- He challenges the author to provide 2 paragraphs of context for every change to bring the viewers up to speed.

### As a reviewer

> **ASK**, don't tell

- Reviewers must overcome negativity bias in written communication.
- Using the Socratic method: instead of commands, reviewers should use questions (e.g. "What do you think about...?" or "Did you consider...?") to simulate critical thinking and discussion.
- Avoid judgemental language (e.g. "Why didn't you JUST do this" or "Did you consider SIMPLY doing that?") when questioning which can make author feel defensive.
  (Basically ask question the right way)

## In practice

### How to handle conflict?

Conflict is good, healthy conflict leads to learning but make sure to distinguish between healthy conflict and unhealthy ones

- Healthy conflict means disagreeing on trade-offs and making compromises. Basically disagreeing on the issue but generally share the same goal (of releasing the software) and following the same process (of code reviews and team work)
- unhealthy conflicts means disagreeing on the process itself, usually resulting in committing code directly to master or ignoring feed back.

For the second case, the team should get together and work on it and reverting option is there if needed.

### What to review

Instead of just looking for bugs, maybe look for:

- Small changes, of which reviews ideally take 10 minutes or less
- Naming and complexity -> Improving names to make code easier to discuss and identifying complex area for clarification.
- Single Responsibility Principle: ensuring objects have only 1 job.
- Reviewing tests as well!
- Conventions and code styles

### Outcomes of a strong culture

- Better code and better developers through group effort and daily learning.
- Team ownership: No more my code vs your code. Every is a shareholder.
- Healthy debate: replacing "silent seething" with productive technical discussion.
