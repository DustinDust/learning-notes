<!-- markdownlint-disable MD013-->

# How to do a code review

Source: [by google](https://google.github.io/eng-practices/review/reviewer/)

## The standard of code review

### The senior principle of approval

It is said the core objective of code review standard is to ensure that the overall code health improves over time. This is achieve through a series of principles that balance technical rigor with the need for development velocity. This means, its a trade-off where:

- The developer must be able to make progress on your task.
- The reviewer Make sure that each change list is of such a quality that the overall code health of the code base is not decreasing as the time goes on.

In other words, the fundamental rule for reviewers is to favor approving a CL (change list) once it definitely improves the overall system code health even though the CL ain't perfect. However, there are 2 major exceptions to this rule;

- Unwanted features: A reviewer can deny a well-designed CL if it adds a feature that is not desired in the system.
- Emergency situation: Code that worsens the system's health should never be submitted unless it is an emergency.

### Mentoring

Code review can have an important function of teaching developers something new about a language, a framework or general software design principles. It's always fine to leave comments that help a developer learn something new. Sharing knowledge is considered part of improving code health of a system overtime.

Keep in mind that if your comment is purely education, not critical to the code base, then you should prefix it with "Nit"

### Principles

When evaluating a CL, the following hierarchy of authority applies:

- Technical facts over Opinion: data and engineering principles always overrule personal preference
- Style guides: the style guide is the absolute authority for matter of style. If something is not covered by the style guide that the reviewer should accept the author's preference
- Software design: Design choice should be weighed against engineering principles. If the author can demonstrate that multiple approaches are equally valid, the reviewer should accept the author’s preference
- Consistency: if no other rule apply, reviewers may ask for consistency with the existing codebase, provided it won't damage the code health
  progress

### Conflict resolution

- When a developer and reviewer cannot agree, they should first attempt to reach a consensus based on established documentation
- If comments are insufficient, a face-to-face or video meeting is recommended to clear up misunderstandings
- If a deadlock persists, the situation should be escalated to a Technical Lead, maintainer, or manager to prevent the CL from sitting idle

## What's to look for in a code review

- Design: This is the most critical aspect. The reviewers must determine if the code interactions makes sense
- Functionality: The CL must perform what the developer intended, benefiting both end-users and future devs. Reviewers should also actively look for bugs, edge cases,...
- User impact: reviewer should validate the behaviour through a demo for changes with user-facing impacts like UI updates
- Complexity: code should be understandable by readers, if stuff are too complex it might lead to future bugs.
  - Reviewers should also be wary against devs adding functionality or overly complex for the present
- Tests: Make sure the CL have either unit, integration or end to end tests as appropriate. The tests must also be valid, useful and will fail if code breaks. The also should be simple enough as they are also code to be maintained
- Naming and comments: names for variables and functions should be clear and descriptive. Comments should generally explain WHY a piece of code exists rather what WHAT it is doing
- External Documentation: if CL changes how users build, tests or interact with code, READMEs and other documentation should be updated
- Styles guides: as mentioned before, CL should follow style guides to the tee.
- Consistency: If the existing codebase is inconsistent with the style guide, code still need to follow the style guide as per principle, but also make sure the changes doesn't go to be too inconsistent with the current codebase' style.
- Every line: general, you should look at every line you need to review, but don't just look at that, make sure to look at surrounding logic and referenced files to gain a better understanding of the system as a whole. Obviously some code need more scrutiny than other so you should make a good judgement on that.
- Context: it's helpful to look at the CL in broader context
- Good things: make positive feedback if you see something nice

## Navigating a CL in review

Step one, take a broad view before diving into the code

- Look at the CL descriptions and what it does in general
- Immediate rejection if the change doesn't make sense or should not have occurred in the first place. But stay courtesy and give alternative suggestions

Step two, examine main parts

- Often the are 1 file or files that are the main parts of this CL which have the large number of logical changes. Look through them first. This help give context to the smaller parts of the CL and accelerates doing the code review
- If you identify major design problems with these main parts, comment right away even if there are parts you haven't reviewed. This helps code that'll based on the current CL and major design changes will take longer than small changes anyways

Step three: look through the rest of the CL in an appropriate sequence

- You can read the test first which will often provide a clear understanding of what the changes is intended to do.

- Use the review tool like Github or VScode diff view,

## Speed of code reviews

Why should it be fast?

Duh, fast review = fast overall delivering speed. Because it's a joint team effort, code review speed is prioritize over the individual speed of any single developer. Bad things actually happen when the code review is slow:

- The velocity of the team as a whole is decreased
- Developer start to protest the code review process: if a reviewer only responds every few days, but the requests major changes to the CL each time, that can be frustrated.
- Code health can be impacted: When reviews are slow, there is increased pressure to allow developers to submit CLs that are not as good as they could be

### So how fast should it be?

Consensus is that **ONE BUSINESS DAY** is the maximum time it should take to respond to a code review. Some CL need and therefore should get multiple rounds of review within a single day.

#### Balancing Speed with productivity

- Protecting focus: If you're in the middle of a focused task such as writing code, no need to interrupt yourself to review code.
- Utilize break points: You can instead wait for a break point in your work to review. This is usually when your current coding task is completed, after lunch, returning from meeting, coming back from break room,...

#### Strategies for faster reviews

- Incremental feedback: when you're too busy, you can still provide quick response regarding when you will be available
- "LGTM" with comments: grant approval even with unresolved comments if the suggestions are minor
- Managing large CLs by splitting into smaller changes
- Cross time zone? Reviewers should aim to respond while the author is still in their working hours or ensure the review is ready before the author starts their next day

## How to write good code reviews

Basically:

- Be kind and courtesy: focus on what and how to improve instead of focusing on making comments about the developer
- Explain your reasoning.
- Balance between giving explicit directions vs pointing out problems and letting the developer to think. Letting the developers think can help the them learn and sometimes giving direct instructions can help improve the CL & save time
- Label comment severity: having a label to indicate the severity of the comment is good, for example `[Nits]` and `[Optional]` means it's minor and not really required but should if possible. `FYI` means providing interesting information (maybe relevant in the future). This helps make the intent explicit and saves time for the developer
- Accepting explanations: explanations written only in code review tool are not helpful for future maintainers so either simplify the code or add comments

## Handling push back in code reviews

Sometimes developer will push back on a code review.

### Who is right?

- Make sure to take a moment to consider if maybe they're correct, since they're closer to the code than you're
- Explain why you think your suggestions is correct, it should demonstrate both your understanding of the developer's reply and additional information on why change is requested
- Stay polite and let them know they're heard

Small note about upsetting developers:

- Developer may become upset but its usually brief and they'll become thankful later if you help improve the quality of their code.
- Usually if you stay polite in the comments they won't be upset at all so you cool

### (No) Cleaning it up later

A very common source of push back is that developers want to get things done, and don't want to go through multiple round of review just to get this CL merged. So they'll say they clean up later and you should just approve this one. Some are good and will do that immediately alter, but the majority will be less likely to actually do that, usually because they are busy with other work. In other words:

> [!IMPORTANT]
> Letting people clean things up later is a common way for codebase to degenerate

Unless it's an emergency, the CL should always be cleaned up before submission
